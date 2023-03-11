package com.twcch.testspringboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 * @Aspect: 將 class 設定為一個切面
 */
@Aspect
@Component
public class MyAspect {

    /*
     * 常用註解:
     * @Before: 在切入點的方法拋出執行前執行
     * @After: 在切入點的方法拋出執行後執行
     * @Around: 在切入點的方法拋出執行前後執行
     * @AfterThrowing: 在切入點的方法拋出異常後執行
     * @AfterReturning: 在切入點的方法執行成功後後執行
     */

    /*
     * @Before(*): 只能在切面的 class 使用，再切入點的方法執行前執行
     * 切入點定義: execution(* com.twcch.testspringboot.controller.TestAOPController.*(..))
     */
    @Before("execution(* com.twcch.testspringboot.controller.TestAOPController.*(..))")
    public void before() {
        System.out.println("I'm before.");
    }

    /*
     * @After(*): 只能在切面的 class 使用，再切入點的方法執行後執行
     */
    @After("execution(* com.twcch.testspringboot.controller.TestAOPController.*(..))")
    public void after(){
        System.out.println("I'm after.");
    }

    /*
     * @Around(*): 只能在切面的 class 使用，再切入點的方法執行前後執行
     */
    @Around("execution(* com.twcch.testspringboot.controller.TestAOPController.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Date start = new Date();

        System.out.println("I'm around before");

        // 執行切入點的方法
        Object obj = proceedingJoinPoint.proceed();

        System.out.println("I'm around after");

        Date end = new Date();

        long time = end.getTime() - start.getTime();

        System.out.println("總共執行了: " + time + " ms");

        return obj;
    }

}
