package com.twcch.testspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello World!";
    }

}
