package com.bo.trade.service;

import com.bo.trade.dto.BO;
import com.bo.trade.dto.BOT;
import com.bo.trade.dto.History;

import java.util.List;

public interface ResultService {
    List<BO> getDataPP(String pp, String sl);

    List<BOT> getDataBot(String cookie, Integer typeBot);

    void saveData();

    String runScan(Long id, Double heSo);

    void runScan();

    List<History> getHistory(String cookie, Long botId);
}
