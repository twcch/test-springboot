package com.twcch.testspringboot.controller;

import com.twcch.testspringboot.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * AOP: aspect-oriented programming
 */
@RestController
@RequestMapping("/test/v1/aop")
public class TestAOPController {

    @Autowired
    @Qualifier("hpPrinterServiceImpl")
    private PrinterService printerService;

    @GetMapping("/hello")
    public String hello(){
        return "Hi";
    }

}
