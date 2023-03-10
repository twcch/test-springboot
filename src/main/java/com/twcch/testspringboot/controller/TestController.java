package com.twcch.testspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @Controller:
 * 方法下的 return 如果是一個 String 就會 return(映射) 一個模板
 */
@Controller
@RequestMapping("/test/v1/2")
public class TestController {

    /*
     * @Controller + @RequestMapping 方法下的 return 如果是一個 String 就會 return(映射) 一個模板
     * @Controller + @ResponseBody = @RestController 映射的效果相同
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello!";
    }


}
