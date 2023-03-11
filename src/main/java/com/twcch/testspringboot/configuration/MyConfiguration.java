package com.twcch.testspringboot.configuration;

import com.twcch.testspringboot.service.PrinterService;
import com.twcch.testspringboot.service.impl.CanonPrinterServiceImpl;
import com.twcch.testspringboot.service.impl.HpPrinterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration 只能加在 class 上，用以 Spring 中設定用註解
 */
@Configuration
public class MyConfiguration {

    /*
     * @Bean(name): 只能在 @Configuration class 中使用，在 Spring 容器中創建一個 bean
     * 有代入 name 可以替 bean 命名，若無則為預設
     */
    @Bean("hp")
    public PrinterService hpPrinter() {
        return new HpPrinterServiceImpl();
    }

    @Bean("canon")
    public PrinterService canonPrinter() {
        return new CanonPrinterServiceImpl();
    }



}
