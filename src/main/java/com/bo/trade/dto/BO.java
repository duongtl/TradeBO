package com.bo.trade.dto;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BO {
    Long OrderID;
    Integer IsWin;
    Integer OrderType;
    JsonObject TimeCreate;
}
