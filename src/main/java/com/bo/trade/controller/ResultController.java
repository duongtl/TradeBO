package com.bo.trade.controller;

import com.bo.trade.dto.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class ResultController {

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("methods", Method.getPP());
        return "home";
    }

    @GetMapping("/error")
    private String error() {
        return "error";
    }
}
