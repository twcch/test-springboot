package com.twcch.testspringboot.rowmapper;

import com.twcch.testspringboot.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    /*
     * Student: 將資料庫的數據轉換成哪種類型的 java object
     * @param rs: 從資料庫查詢出來的數據
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();
        /*
         * 取得 sql column: id 的資料
         */
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));

        return student;

    }

}
