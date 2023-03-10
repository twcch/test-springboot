package com.twcch.testspringboot.controller;

import com.twcch.testspringboot.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/v1/ioc")
public class TestIOCController {

    /*
     * DI: dependency injection (依賴注入)
     * @Autowired 查看 PrinterService 是否有 printer 的 bean ，若有會將 bean 注入
     * @Qualifier(name) 可以指定注入特定名稱的 bean
     */
    @Autowired
    @Qualifier("hp")
    private PrinterService printer;

    @GetMapping("/print")
    public String print(){

        printer.print("Hello world!");

        return "Hi";
    }

}
