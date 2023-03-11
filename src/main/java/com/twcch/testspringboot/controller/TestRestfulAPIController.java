package com.twcch.testspringboot.controller;

import com.twcch.testspringboot.model.Student;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/*
 * @Validated: 使用 spring boot 驗證請求參數功能，讓 controller 使用驗證註解
 */
@RestController
@RequestMapping("/test/v1/restful")
public class TestRestfulAPIController {

    /*
     * 資料庫操作: Create, Http method: POST, 新增一個資源
     * 資料庫操作: Read, Http method: GET, 取得一個資源
     * 資料庫操作: Update, Http method: PUT, 更新一個已存在的資源
     * 資料庫操作: Delete, Http method: DELETE, 刪除一個資源
     */

    /*
     * @Valid: 使用 spring boot 驗證請求參數功能，@RequestBody 的註解
     */
    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student) {
        return "執行資料庫 create 操作";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "執行資料庫 read 操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student,
                         @RequestHeader String info) {
        return "執行資料庫 update 操作";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "執行資料庫 delete 操作";
    }

}
