package com.twcch.testspringboot.controller;

import com.twcch.testspringboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/v1/param")
public class TestParamController {

    /*
     * 獲取一條書單
     */
    @GetMapping("/getbook/{id}/{name}")
    /*
     * @PathVariable 獲取 url 中 id 的註解
     */
    public Object getBook(@PathVariable long id,
                          @PathVariable String name) {

        System.out.println(" --- id: " + id);
        System.out.println(" --- name: " + name);

        Map<String, Object> book = new HashMap<>();
        book.put("name", "互聯網世界觀");
        book.put("isbn", "9877234623432");
        book.put("author", "Alan");
        book.put("user", name);

        return book;
    }

    /*
     * 新增一條書單
     */
    @PostMapping("/postbook")
    /*
     * @RequestParam 接收前端傳的參數
     * @RequestParam(varName) 接收前端傳的參數，有指定變數名稱，順序就可以不一樣
     */
    public Object postBook(@RequestParam("name") String name,
                           @RequestParam("author") String author,
                           @RequestParam("isbn") String isbn) {

        System.out.println(" --- name: " + name);
        System.out.println(" --- author: " + author);
        System.out.println(" --- isbn: " + isbn);

        Map<String, Object> book = new HashMap<>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);

        return book;
    }

    @GetMapping("/books")
    /*
     * @RequestParam(varName) 接收前端傳的參數，有指定變數名稱，順序就可以不一樣，強制一定要給
     * @RequestParam(value = varName, defaultValue = varName) 接收前端傳的參數，沒有強制一定要給，當沒有給會有預設值
     */
    public Object getBookList(@RequestParam(value = "page", defaultValue = "10") int page,
                              @RequestParam("size") int size) {

        Map<String, Object> book = new HashMap<>();
        book.put("name", "互聯網世界觀");
        book.put("isbn", "9877234623432");
        book.put("author", "Alan");

        Map<String, Object> book2 = new HashMap<>();
        book.put("name", "哈利波特");
        book.put("isbn", "9877234123456");
        book.put("author", "Judy");

        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page", page);
        pagemap.put("size", size);
        pagemap.put("contents", contents);

        return pagemap;
    }

    @GetMapping("/user")
    public String getInfo(@RequestParam(value = "name", defaultValue = "null") String name,
                          @RequestParam(value = "age", defaultValue = "0") int age) {

        return "My name is " + name + ", I'm " + age + " years old.";
    }

    @PostMapping("/student")
    /*
     * @RequestBody: 獲取 body 的資訊
     */
    public String postInfo(@RequestBody Student student) {

        System.out.println("id: " + student.getId());
        System.out.println("name: " + student.getName());

        return "Hello";
    }

    @RequestMapping("/head")
    /*
     * @RequestHeader: 獲取 header 的資訊
     * @RequestHeader(required = false): true 必須為 header 的 request
     * @RequestHeader(defaultValue = "application/json"): 提供預設值
     */
    public String getHeader(@RequestHeader String info) {

        System.out.println("info: " + info);

        return "Hello";
    }

}
