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
        //TODO Should operations be performed on the controller?
        //TODO Division by zero is possible. Throws internal server error (500).
        int operationResult;
        switch (operation) {
            case "sum":         operationResult = a+b; break;
            case "subtract":    operationResult = a-b; break;
            case "multiply":    operationResult = a*b; break;
            case "divide":      operationResult = a/b; break;
            default:            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                    .body(new ApiError ("Unsupported operation.", "Valid operations are sum, subtract, multiply and divide."));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response(a, operation, b, operationResult));
    }
}
