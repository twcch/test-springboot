package com.twcch.testspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * RestController: 將 class 標示為外部控制器
 * RestController 下的 return 如果是一個 String 就會 return 一個 String
 * RestController 下的 return 如果是一個實例對象就會 return 一個 json 格式
 */
@RestController
public class DemoController {

    /*
     * url rule: http://localhost:8080/api/version/name
     */
    @RequestMapping("/testspringboot/v1/helloworld")
    public String helloworld() {
        return "Hello World!";
    }

}
