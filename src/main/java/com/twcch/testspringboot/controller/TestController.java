package com.twcch.testspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController: 將 class 標示為外部控制器
 * @RestController 下的 return 如果是一個 String 就會 return 一個 String
 * @RestController 下的 return 如果是一個實例對象就會 return 一個 json 格式
 */
@RestController
/*
 * @RequestMapping 用於 class
 * url rule: http://localhost:8080/api/version/name
 */
@RequestMapping("/test1/v1/")
public class TestController {

    /*
     * @RequestMapping 用於方法
     * @RequestMapping: 將方法標示為處理外部請求
     */
    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello World!";
    }

    /*
     * 聲明處理請求的類型:
     * @RequestMapping(value = "url", method = RequestMethod.GET)
     * @RequestMapping(value = "url", method = RequestMethod.POST)
     * @RequestMapping(value = "url", method = RequestMethod.PUT)
     * @RequestMapping(value = "url", method = RequestMethod.DELETE)
     */
    @RequestMapping(value = "/testspringboot/v2/helloworld", method = RequestMethod.GET)
    public String helloworld2() {
        return "Hello World2!";
    }

}
