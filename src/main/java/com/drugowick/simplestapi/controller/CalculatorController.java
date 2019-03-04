package com.drugowick.simplestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @RequestMapping("/sum")
    public @ResponseBody int sum(@RequestParam int a, @RequestParam int b) {
        return a+b;
    }

    @RequestMapping("/subtract")
    public @ResponseBody int subtract(@RequestParam int a, @RequestParam int b) {
        return a-b;
    }

    @RequestMapping("/divide")
    public @ResponseBody int divide(@RequestParam int a, @RequestParam int b) {
        return a/b;
    }

    @RequestMapping("/multiply")
    public @ResponseBody int multiply(@RequestParam int a, @RequestParam int b) {
        return a*b;
    }
}
