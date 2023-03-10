package com.twcch.testspringboot.service.impl;

import com.twcch.testspringboot.service.PrinterService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * IOC: inversion of control (控制反轉)
 * @Component 將 class 包裝成一個 bean
 * bean: 透過 spring boot 包裝的 object
 */
@Component
public class HpPrinterServiceImpl implements PrinterService {

    private int count;
    /*
     * @Value("${value}"): 不設定預設值，將 application.properties 設定的值取出來
     * @Value("${value:default value}"): 設定預設值，將 application.properties 設定的值取出來，當取不到值，會使用預設值
     */
    @Value("${printer.name:Amy}")
    private String owner;

    /*
     * @PostConstruct: 當 bean 被注入後，就會執行初始化內容
     * 存取權限修飾子必須為 public 且為 void
     * 方法名稱沒有限定，但必須無傳入值
     */
    @PostConstruct
    public void initialize() {
        count = 10;
    }

    @Override
    public void print(String message) {
        count--;
        System.out.println("HP Printer: " + message);
        System.out.println("剩餘使用次數: " + count);
        System.out.println(owner);
    }

}
