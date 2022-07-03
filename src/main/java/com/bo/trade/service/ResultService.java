package com.bo.trade.service;

import com.bo.trade.dto.BO;

import java.util.List;

public interface ResultService {
    List<BO> getData(String pp, String sl);

    void saveData();

    String runScan(Long id, Double heSo);

    void runScan();
}
