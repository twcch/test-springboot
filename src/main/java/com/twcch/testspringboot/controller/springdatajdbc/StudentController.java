package com.twcch.testspringboot.controller.springdatajdbc;

import com.twcch.testspringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test/v1/jdbc")
public class StudentController {

    /*
     * 因為 application.properties 有相關 database connection 配置， spring boot 啟動後會創建 NamedParameterJdbcTemplate bean
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {

        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        /*
         * map: 動態的得知目前 sql 的值是多少
         */
        namedParameterJdbcTemplate.update(sql, map);

        return "執行 INSERT SQL";

    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql,map);

        return "執行 DELETE SQL";
    }

}
