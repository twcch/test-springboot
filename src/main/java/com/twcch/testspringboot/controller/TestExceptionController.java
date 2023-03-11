package com.twcch.testspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/v1/exception")
public class TestExceptionController {

    @RequestMapping("/test1")
    public String test1() {
        throw new RuntimeException("test1 error!");
    }

    @RequestMapping("/test2")
    public String test2() {
        throw new IllegalArgumentException("test2 error!");
    }

}
