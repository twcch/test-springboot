package com.twcch.testspringboot.service.impl;

import com.twcch.testspringboot.service.PrinterService;
import org.springframework.stereotype.Component;

/*
 * IOC: inversion of control (控制反轉)
 * @Configuration 只能加在 class 上，Spring 中設定用註解
 */
@Component
public class CanonPrinterServiceImpl implements PrinterService {

    /*
     * bean: 透過 spring boot 包裝的 object
     */
    @Override
    public void print(String message) {
        System.out.println("Canon Printer: " + message);
    }

}
