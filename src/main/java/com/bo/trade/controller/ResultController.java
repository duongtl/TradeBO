package com.bo.trade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class ResultController {

    @GetMapping()
    private String home() {
        return "home";
    }

    @GetMapping("/error")
    private String error() {
        return "error";
    }
}
