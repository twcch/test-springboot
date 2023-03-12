package com.twcch.testspringboot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Student {

    /*
     * 使用 spring boot 驗證請求參數註解:
     * @NotNull: 不能為 null
     * @NotBlank: 不能為 null 且不能為空白的字串，用在驗證 String 類型的參數上
     * @NotEmpty: 不能為 null 且 size > 0 ，用在驗證集合類型 (List, Set, Map) 的參數上
     * @Min(value): 值必須 >= value 用在驗證數字類型的參數上
     * @Max(value): 值必須 <= value 用在驗證數字類型的參數上
     */

    /*
     * @NotNull: 使用 spring boot 驗證請求參數功能，限制不可傳入 null
     */
    // @NotNull
    private Integer id;
    @NotBlank
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
