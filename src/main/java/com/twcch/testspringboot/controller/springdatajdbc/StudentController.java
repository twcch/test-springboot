package com.twcch.testspringboot.controller.springdatajdbc;

import com.twcch.testspringboot.model.Student;
import com.twcch.testspringboot.rowmapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

        String sql = "INSERT INTO student(name) VALUES (:studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        /*
         * map: 動態的得知目前 sql 的值是多少
         */
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成 id : " + id);

        return "執行 INSERT SQL";

    }

    @PostMapping("/students/batch")
    /*
     * @RequestBody List<Student> studentList: 接收前端 json array
     */
    public String insertList(@RequestBody List<Student> studentList) {

        String sql = "INSERT INTO student(name) VALUES (:studentName)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);

            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);

        return "執行 batch INSERT SQL";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);

        return "執行 DELETE SQL";
    }

    @GetMapping("/students")
    public List<Student> select() {

        String sql = "SELECT id, name FROM student";

        Map<String,Object> map = new HashMap<>();

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list;

    }

    @GetMapping("/students/{studentId}")
    public Student selectOne(@PathVariable Integer studentId) {

        String sql = "SELECT id, name FROM student WHERE id = :studentId";

        Map<String, Object> map =new HashMap<>();
        map.put("studentId", studentId);

        // query 方法固定 return list
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

}
