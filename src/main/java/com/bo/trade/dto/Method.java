package com.bo.trade.dto;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Method {
    public static final String PP = "[{\"id\":\"0\",\"name\":\"Reverse (Theo kết quả)\"},{\"id\":\"1\",\"name\":\"Smart AI 1\"},{\"id\":\"2\",\"name\":\"Smart AI 2\"},{\"id\":\"3\",\"name\":\"SideWay 1-1 (Ngược kết quả)\"},{\"id\":\"4\",\"name\":\"Chỉ báo tâm lý (% cao)\"},{\"id\":\"5\",\"name\":\"Chỉ báo tâm lý (% thấp)\"},{\"id\":\"6\",\"name\":\"Chỉ đặt tăng\"},{\"id\":\"7\",\"name\":\"Chỉ đặt giảm\"},{\"id\":\"8\",\"name\":\"Smart Surf 1 (Theo nến chờ)\"},{\"id\":\"9\",\"name\":\"Ping Pong (Ngược nến chờ)\"},{\"id\":\"10\",\"name\":\"AwsBot\"},{\"id\":\"11\",\"name\":\"Giọt nước rơi\"},{\"id\":\"12\",\"name\":\"Smart Surf AI\"},{\"id\":\"13\",\"name\":\"Mix Smart\"},{\"id\":\"15\",\"name\":\"Song Song\"},{\"id\":\"16\",\"name\":\"Xương Cá\"},{\"id\":\"17\",\"name\":\"Chữ M\"},{\"id\":\"18\",\"name\":\"Bóng 1\"},{\"id\":\"19\",\"name\":\"Bóng 9\"},{\"id\":\"20\",\"name\":\"Hàng 1F\"},{\"id\":\"21\",\"name\":\"Hàng 3F\"},{\"id\":\"22\",\"name\":\"Slanting Line\"},{\"id\":\"23\",\"name\":\"Tứ Trụ\"},{\"id\":\"24\",\"name\":\"Diagonal Line\"},{\"id\":\"25\",\"name\":\"Chữ V\"},{\"id\":\"26\",\"name\":\"Slanting Line V2\"},{\"id\":\"27\",\"name\":\"Hàng 1\"},{\"id\":\"28\",\"name\":\"Hàng 3\"},{\"id\":\"29\",\"name\":\"Chữ W\"},{\"id\":\"30\",\"name\":\"Trending SMA\"},{\"id\":\"31\",\"name\":\"SAW 135\"},{\"id\":\"32\",\"name\":\"SAW 124\"},{\"id\":\"34\",\"name\":\"Các Ngọn Nến\"},{\"id\":\"35\",\"name\":\"Chữ L\"},{\"id\":\"36\",\"name\":\"Bậc Thang\"},{\"id\":\"37\",\"name\":\"Số 5\"},{\"id\":\"38\",\"name\":\"Tam Sao\"},{\"id\":\"39\",\"name\":\"Mountain River\"},{\"id\":\"40\",\"name\":\"UnderWear\"},{\"id\":\"41\",\"name\":\"Ba Chàng Lính\"},{\"id\":\"42\",\"name\":\"Chữ X\"},{\"id\":\"43\",\"name\":\"Tank Wheel\"},{\"id\":\"44\",\"name\":\"Số 7\"},{\"id\":\"45\",\"name\":\"Bóng 1-10\"},{\"id\":\"46\",\"name\":\"Hàng 1-3\"},{\"id\":\"47\",\"name\":\"Xương Cá V2\"},{\"id\":\"49\",\"name\":\"Cản Đỉnh / Đáy\"},{\"id\":\"50\",\"name\":\"Táo V1\"},{\"id\":\"53\",\"name\":\"Hàng 1B\"},{\"id\":\"54\",\"name\":\"Hàng 3B\"},{\"id\":\"55\",\"name\":\"56\"},{\"id\":\"56\",\"name\":\"B14\"},{\"id\":\"57\",\"name\":\"B12\"},{\"id\":\"58\",\"name\":\"Trending EMA\"},{\"id\":\"59\",\"name\":\"Lực nến đơn\"},{\"id\":\"60\",\"name\":\"Lực nến đôi\"},{\"id\":\"61\",\"name\":\"Lực nến 2 phút\"},{\"id\":\"62\",\"name\":\"Lực nến 3 phút\"},{\"id\":\"63\",\"name\":\"Lực nến 5 phút\"},{\"id\":\"64\",\"name\":\"Cột 1-2\"},{\"id\":\"65\",\"name\":\"Cột 1-2 H1\"},{\"id\":\"66\",\"name\":\"Cột 1-2 H3\"}]";
    static Gson gson = new Gson();
    Integer id;
    String name;

    public static List<Method> getPP() {
        return Arrays.stream(gson.fromJson(PP, Method[].class)).collect(Collectors.toList());
    }
}
