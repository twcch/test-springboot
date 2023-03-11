package com.twcch.testspringboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * @Aspect: 將 class 設定為一個切面
 */
@Aspect
@Component
public class RecordRunTime {

    /*
     * @Before(*): 只能在切面的 class 使用，再切入點的方法執行前執行
     * 切入點定義: execution(* com.twcch.testspringboot.controller.TestAOPController.*(..))
     */
    @Before("execution(* com.twcch.testspringboot.controller.TestAOPController.*(..))")
    public void before() {
        System.out.println("I'm before.");
    }

}
