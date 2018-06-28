package com.c4tman.play.design.pattern.frs.service;

import com.c4tman.play.design.pattern.frs.annotation.LimitMethod;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxiaoman on 2018/6/28.
 */
@Service
public class ServiceA {

    @LimitMethod(timeUnit = 5 * 1000, maxTime = 2)
    public void method1(){
        System.out.println("access method1");
    }

    @LimitMethod(timeUnit = 5 * 1000, keyWord = "int")
    public void method1(int i){
        System.out.println("access method1[int]");
    }

    @LimitMethod
    public void method2(String str1, String str2){
        System.out.println("access method2");
    }
}
