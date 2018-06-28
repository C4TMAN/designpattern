package com.c4tman.play.design.pattern.frs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangxiaoman on 2018/6/28.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LimitMethod {
    //限制时间 单位毫秒
    int timeUnit() default 60 * 1000;

    //限制时间内的最大访问次数
    int maxTime() default 1;

    //匹配关键字
    //默认ip-类名-方法名-keyWord
    String keyWord() default "";
}
