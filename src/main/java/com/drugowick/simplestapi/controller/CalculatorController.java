package com.drugowick.simplestapi.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    /**
     * A Response inner class to provide the response.
     */
    @Data
    public class Response {
        private final int a;
        private final String operation;
        private final int b;
        private final int result;
    }

    @Data
    public class ApiError {
        private final String error;
        private final String advice;
    }

    @RequestMapping(value = "/calc", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity calc(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam(required = false, defaultValue = "sum") String operation)
    {
        switch (operation) {
            case "sum":         return ResponseEntity.status(HttpStatus.OK).body(new Response(a, "sum", b, a+b));
            case "subtract":    return ResponseEntity.status(HttpStatus.OK).body(new Response(a, "subtract", b, a-b));
            case "multiply":    return ResponseEntity.status(HttpStatus.OK).body(new Response(a, "multiply", b, a*b));
            case "divide":      return ResponseEntity.status(HttpStatus.OK).body(new Response(a, "divide", b, a/b));
            default:            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError ("Unsupported operation.", "Valid operations are sum, subtract, multiply and divide."));
        }
    }
}
