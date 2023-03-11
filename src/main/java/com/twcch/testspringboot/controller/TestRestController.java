package com.twcch.testspringboot.controller;

import com.twcch.testspringboot.model.Store;
import com.twcch.testspringboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Http Request:
 * http method: GET, POST, PUT, DELETE
 * url
 * request header: 放一些通用的資訊
 * request body: 放請求參數(只有在使用 POST 和 PUT 時才能使用)
 */

/*
 * Http Response:
 * http status code: 表示請求結果(1xx: 資訊, 2xx: 成功, 3xx: 重新導向, 4xx: 前端請求錯, 5xx: 後端處理有問題)
 * response header: 放一些通用的資訊
 * response body: 放後端返回的資訊
 */

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
@RequestMapping("/test/v1/rest")
public class TestRestController {

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
    public Store getHello() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("西瓜");
        store.setProductList(list);
        return store;
    }

    /*
     * @RequestMapping 的簡寫形式
     * @GetMapping("url")
     * @PostMapping("url")
     * @PutMapping("url")
     * @DeleteMapping("url")
     */
    @GetMapping("/sgethello")
    public User sGetHello() {
        User user = new User();
        user.setName("Amy");
        return user; // Spring boot 使用 jackson library 轉換 java class 和 json 格式
    }

}
