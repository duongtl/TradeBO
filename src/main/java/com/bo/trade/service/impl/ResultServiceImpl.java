package com.bo.trade.service.impl;

import com.bo.trade.dto.BO;
import com.bo.trade.dto.Method;
import com.bo.trade.entity.ResultEntity;
import com.bo.trade.repository.ResultRepository;
import com.bo.trade.service.ResultService;
import com.bo.trade.websocket.SessionManager;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private static final String URL = "https://superxbot.com/api/signal/logmix.php";
    private final ResultRepository resultRepository;
    List<Method> methods = Method.getPP();
    String a = "1-1-2-2-3-4-05-07-10-13-18-24-32-44-059-080-108-146-197-271";
    String b = "1-2-4-4-6-8-10-14-20-26-36-48-64-88-118-160-216-292-394-542";

    /*
    public static StringBuilder replaceAll(StringBuilder sb, String find, String replace) {
        return new StringBuilder(Pattern.compile(find).matcher(sb).replaceAll(replace));
    }
     */

    @Override
    public List<BO> getData(String pp, String sl) {
        long start = System.currentTimeMillis();
        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("listPP", pp);
        map.put("getCount", sl);
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, map, String.class, entity);
        String res = responseEntity.getBody();
        if (res == null) {
            return new ArrayList<>();
        }
        if (res.equals("false")) {
            return new ArrayList<>();
        }
        BO[] arr = gson.fromJson(responseEntity.getBody(), BO[].class);
        System.out.println("Fetch time: " + (System.currentTimeMillis() - start) + "ms ");
        return Arrays.stream(arr).sorted((o1, o2) -> (int) (o1.getOrderID() - o2.getOrderID())).collect(Collectors.toList());
    }

    @Override
    public void saveData() {
        for (Method method : methods) {
            List<BO> data = getData(String.valueOf(method.getId()), "1000");
            List<ResultEntity> entities = data.stream().map(bo -> toEntity(bo, method)).collect(Collectors.toList());
            ResultEntity lastResult = resultRepository.findFirstByMethodIdOrderByIdDesc(Long.valueOf(method.getId()));
            if (lastResult != null) {
                entities = entities.stream().filter(resultEntity -> resultEntity.getOrderId() > lastResult.getOrderId()).collect(Collectors.toList());
            }
            log.info("Method {}, size {}", method.getName(), entities.size());
            resultRepository.saveAll(entities);
        }

    }

    private ResultEntity toEntity(BO bo, Method pp) {
        return ResultEntity.builder()
                .methodId(Long.valueOf(pp.getId()))
                .createdAt(Timestamp.from(Instant.now()))
                .isWin(bo.getIsWin().equals(1))
                .orderType(bo.getOrderType())
                .orderId(bo.getOrderID())
                .timeCreate(Timestamp.valueOf(bo.getTimeCreate().get("date").getAsString()))
                .build();
    }

    @Override
    public void runScan() {
        double heSo = 1;
        List<Double> aa = getIndex(heSo, a);
        List<Double> bb = getIndex(heSo, b);

        for (int xx = 0; xx <= 66; xx++) {
            logData(xx, false, methods, aa, bb);
        }
    }

    @Override
    public String runScan(Long id, Double heSo) {
        if (heSo == null) {
            heSo = 1D;
        }
        List<Double> aa = getIndex(heSo, a);
        List<Double> bb = getIndex(heSo, b);
        return logData(id.intValue(), true, methods, aa, bb);
    }

    private String logData(Integer xx, Boolean log, List<Method> methods, List<Double> aa, List<Double> bb) {
        StringBuilder stringBuilder = new StringBuilder();
        List<BO> data = getData(String.valueOf(xx), "1000");
        if (data.isEmpty() || xx >= methods.size()) {
            return "No data";
        }
        Method method = methods.stream().filter(method1 -> method1.getId().equals(xx)).findFirst().orElse(null);
        if (method == null) {
            return "No data";
        }
        String pp = method.getId() + " - " + method.getName();
        stringBuilder.append(String.format("%s %s%n", "Phương pháp", pp));
        List<Boolean> result = data.stream().map(bo -> bo.getIsWin() == 1).collect(Collectors.toList());
        double usd = 1000, mock = usd, changed, maxUsd = usd;
        DecimalFormat df = new DecimalFormat("#.##");
        int winCount = 0, i = 0, chay = 0;
        long phien;
        boolean win;
        String empty = " ";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Timestamp from = Timestamp.valueOf(data.get(0).getTimeCreate().get("date").getAsString());
        Timestamp to = Timestamp.valueOf(data.get(data.size() - 1).getTimeCreate().get("date").getAsString());
        stringBuilder.append(String.format("%s %s %s %s%n", "Thời gian từ", sdf.format(from), "đến", sdf.format(to)));
        String timeBO;
        for (int j = 0; j < result.size(); j++) {
            phien = data.get(j).getOrderID();
            win = result.get(j);
            timeBO = sdf2.format(Timestamp.valueOf(data.get(j).getTimeCreate().get("date").getAsString()));
            if (win) {
//                nếu win
                String change;
                winCount++;
                if (winCount == 1) {
                    //nếu win 1 phiên
                    usd += aa.get(i) * 0.95;
                    if (i == 0) {
                        changed = usd - mock;
                        if (log) {
                            String winMoney = df.format(aa.get(i) * 1.95);
                            if (changed < 0) {
                                change = "➤ - " + df.format(-changed) + " $";
                            } else {
                                change = "➤ + " + df.format(changed) + " $";
                            }
                            stringBuilder.append(String.format("%s %s đánh %-4s %s %-5s %-7s %s %-11s %-11s %-8s %s%n",
                                    timeBO + " - Phiên", phien, df.format(aa.get(i)), empty, "WIN:", "+ " + winMoney, empty, "    Money: ", df.format(usd) + "$", empty, change));
                        }
                        mock = usd;
                    } else {
                        if (log) {
                            String winMoney = df.format(aa.get(i) * 1.95);
                            stringBuilder.append(String.format("%s %s đánh %-4s %s %-5s %-7s %s %-11s %s$%n",
                                    timeBO + " - Phiên", phien, df.format(aa.get(i)), empty, "WIN:", "+ " + winMoney, empty, "    Money: ", df.format(usd)));
                        }
                    }

                } else {
                    //nếu win từ 2 phiên
                    usd += bb.get(i) * 0.95;
                    changed = usd - mock;
                    if (log) {
                        String winMoney = df.format(bb.get(i) * 1.95);
                        if (changed < 0) {
                            change = "➤ - " + df.format(-changed) + " $";
                        } else {
                            change = "➤ + " + df.format(changed) + " $";
                        }
                        stringBuilder.append(String.format("%s %s đánh %-4s %s %-5s %-7s %s %-11s %-11s %-8s %s%n",
                                timeBO + " - Phiên", phien, df.format(bb.get(i)), empty, "WIN:", "+ " + winMoney, empty, "    Money: ", df.format(usd) + "$", empty, change));
                    }
                    mock = usd;
                }

                if (usd >= maxUsd) {
                    maxUsd = usd;
                }
            } else {
                if (winCount == 0) {
                    usd -= aa.get(i);
                    if (log) {
                        stringBuilder.append(String.format("%s %s đánh %-4s %s %-5s %-7s %s %-11s %s$%n",
                                timeBO + " - Phiên", phien, df.format(aa.get(i)), empty, "LOSS:", "+ " + df.format(0), empty, "    Money: ", df.format(usd)));
                    }
                } else {
                    usd -= bb.get(i);
                    if (log) {
                        stringBuilder.append(String.format("%s %s đánh %-4s %s %-5s %-7s %s %-11s %s$%n",
                                timeBO + " - Phiên", phien, df.format(bb.get(i)), empty, "LOSS:", "+ " + df.format(0), empty, "    Money: ", df.format(usd)));
                    }
                    winCount--;
                }
            }

            if (!win) {
                i++;
                if (i >= aa.size()) {
                    if (log) {
                        stringBuilder.append(String.format("%n%s CHÁY %s%n%n", line("─", 36), line("─", 36)));
                    }
                    chay++;
                    i = 0;
                }
            }

            if (winCount == 2) {
                winCount = 0;
                i = 0;
            }
        }
        if (usd >= 1000) {
            stringBuilder.append(String.format("%s %6s%n", "Kết quả lãi: ", df.format(usd - 1000) + "$"));
        } else {
            stringBuilder.append(String.format("%s %6s%n", "Kết quả lỗ: ", df.format(1000 - usd) + "$"));
        }

        int totalWin = 0, totalLoss = 0, llt = 0, wlt = 0, maxLLT = 0, maxWLT = 0;
        List<Integer> kcPhien = new ArrayList<>();
        for (int iq = 0; iq < data.size(); iq++) {
            if (data.get(iq).getIsWin() == 1) {
                totalWin++;
                if (iq > 0 && data.get(iq - 1).getIsWin() == 1) {
                    wlt++;
                    if (wlt > maxWLT) {
                        maxWLT = wlt;
                    }
                    if (wlt >= 2) {
                        kcPhien.add(iq + 1);
                    }
                } else {
                    wlt = 1;
                }
            } else {
                totalLoss++;
                if (iq > 0 && data.get(iq - 1).getIsWin() != 1) {
                    llt++;
                    if (llt > maxLLT) {
                        maxLLT = llt;
                    }
                } else {
                    llt = 1;
                }
            }
        }

        stringBuilder.append(String.format("%-5s %d (%2d liên thông)%n", "WIN:", totalWin, maxWLT));
        stringBuilder.append(String.format("%-5s %d (%2d liên thông)%n", "LOSS:", totalLoss, maxLLT));
        stringBuilder.append(String.format("%-5s %.2f %s%n", "TLWin:", 100D * totalWin / (totalWin + totalLoss), "%"));

        if (log) {
            List<Integer> kc = new ArrayList<>();
            for (int i1 = 0; i1 < kcPhien.size(); i1++) {
                if (i1 > 0) {
                    kc.add(kcPhien.get(i1) - kcPhien.get(i1 - 1));
                }
            }
            stringBuilder.append(String.format("%10s %s\n", "Khoảng cách win: ", Arrays.toString(kc.toArray())));
            stringBuilder.append(String.format("%10s %d\n", "Tổng phiên win: ", kc.size()));
            stringBuilder.append(String.format("%10s %d\n", "Tổng phiên cháy: ", chay));
        }
        stringBuilder.append(String.format("%s\n", line("─", 72)));
        System.out.println(stringBuilder);
        SessionManager.sendAll(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private List<Double> getIndex(Double heSo, String ab) {
        return Arrays.stream(ab.split("[^0-9]")).map(s -> Double.parseDouble(s) * heSo).collect(Collectors.toList());
    }

    private String line(String c, Integer length) {
        return IntStream.rangeClosed(1, length).mapToObj(value -> "").collect(Collectors.joining(c));
    }

}
