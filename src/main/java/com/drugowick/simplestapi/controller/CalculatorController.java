package com.drugowick.simplestapi.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    /**
     * A Response inner class to provide the response.
     */
    @Data
    public class Response {
        private int a;
        private String operation;
        private int b;
        private int result;
        private String error;

        public Response(String error) {
            this.error = error;
        }

        public Response(int a, String operation, int b, int result) {
            this.a = a;
            this.operation = operation;
            this.b = b;
            this.result = result;
        }
    }

    @RequestMapping("/calc")
    public Response calc(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam(required = false, defaultValue = "sum") String operation)
    {
        switch (operation) {
            case "sum": return new Response(a, "sum", b, a+b);
            case "subtract": return new Response(a, "subtract", b, a-b);
            case "multiply": return new Response(a, "multiply", b, a*b);
            case "divide": return new Response(a, "divide", b, a/b);
            default: return new Response("Valid operations are sum (default), subtract, multiply or divide.");
        }
    }
}
