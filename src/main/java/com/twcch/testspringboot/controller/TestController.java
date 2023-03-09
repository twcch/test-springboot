package com.twcch.testspringboot.controller;

import org.springframework.web.bind.annotation.*;

/*
 * @RestController:
 * 主要用於更加快速的建構 RESTful Web 服務
 * 將 class 標示為外部控制器
 * 方法下的 return 如果是一個 String 就會 return(映射) 一個 String
 * 方法下的 return 如果是一個實例對象就會 return(映射) 一個 json 格式
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
    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    /*
     * 聲明處理請求的類型:
     * @RequestMapping(value = "url", method = RequestMethod.GET)
     * @RequestMapping(value = "url", method = RequestMethod.POST)
     * @RequestMapping(value = "url", method = RequestMethod.PUT)
     * @RequestMapping(value = "url", method = RequestMethod.DELETE)
     * 如果沒有限制 method 表示所有的請求都支持
     */
    @RequestMapping(value = "/gethello", method = RequestMethod.GET)
    public String getHello() {
        return "Hi!";
    }

    /*
     * @RequestMapping 的簡寫形式
     * @GetMapping("url")
     * @PostMapping("url")
     * @PutMapping("url")
     * @DeleteMapping("url")
     */
    @GetMapping("/sgethello")
    public String sGetHello() {
        return "Hi!";
    }

}
