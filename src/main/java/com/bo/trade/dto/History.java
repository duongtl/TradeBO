package com.bo.trade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {
    Long BotID;
    Long SessionID;
    String BetType;
    Integer Result;
    Long BetTime;
    BigDecimal BetAmount;
    BigDecimal WinAmount;
    String Message;
    String PhuongPhap;
}
