package com.bo.trade.controller;

import com.bo.trade.service.ResultService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class HomeController {
    private final ResultService resultService;

    @GetMapping("/save")
    private ResponseEntity<?> scanDataAndSave() {
        resultService.saveData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<?> setListBot(@RequestParam("cookie") String cookie, @RequestParam("type") Integer type) {
        return new ResponseEntity<>(resultService.getDataBot(cookie, type), HttpStatus.OK);
    }

    @GetMapping("/get-history")
    private ResponseEntity<?> getHistoryBot(@RequestParam("cookie") String cookie, @RequestParam("bot_id") Long botId) {
        return new ResponseEntity<>(resultService.getHistory(cookie, botId), HttpStatus.OK);
    }

    @GetMapping("/scan")
    private ResponseEntity<?> scanData() {
        resultService.runScan();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping("/scan/{id}/{he_so}")
    private ResponseEntity<?> scanDataOne(@PathVariable("id") Long id, @PathVariable(name = "he_so", required = false) Double heSo) {
        return new ResponseEntity<>(resultService.runScan(id, heSo), HttpStatus.OK);
    }
}
