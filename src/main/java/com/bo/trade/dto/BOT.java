package com.bo.trade.dto;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BOT {
    Long BotID;
    String BotName;
    Integer isPlayingBot;
    BigDecimal ProfitDay;
    BigDecimal TotalProfit;
    Integer WinTotal;
    Integer LoseTotal;
    Integer WinDay;
    Integer LoseDay;
}
