package com.twcch.testspringboot.service.impl;

import com.twcch.testspringboot.service.PrinterService;
import jakarta.annotation.PostConstruct;
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
    }

}
