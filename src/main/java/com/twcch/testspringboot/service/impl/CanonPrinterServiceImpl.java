package com.twcch.testspringboot.service.impl;

import com.twcch.testspringboot.service.PrinterService;
import org.springframework.stereotype.Component;

/*
 * IOC: inversion of control (控制反轉)
 * @Component 將 class 包裝成一個 bean
 * bean: 透過 spring boot 包裝的 object
 */
@Component
public class CanonPrinterServiceImpl implements PrinterService {

    @Override
    public void print(String message) {
        System.out.println("Canon Printer: " + message);
    }

}
