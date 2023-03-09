package com.twcch.testspringboot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/param/v1/")
public class ParamController {

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

}
