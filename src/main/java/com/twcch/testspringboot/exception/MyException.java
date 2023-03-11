package com.twcch.testspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * @ControllerAdvice + @ExceptionHandler(RuntimeException.class): 定義 RuntimeException 的 http response
 * @ControllerAdvice + @ExceptionHandler(IllegalArgumentException.class): 定義 IllegalArgumentException 的 http response
 */
@ControllerAdvice
public class MyException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handle(RuntimeException runtimeException) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("RuntimeException: "+ runtimeException.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("IllegalArgumentException: "+ illegalArgumentException.getMessage());
    }

}
