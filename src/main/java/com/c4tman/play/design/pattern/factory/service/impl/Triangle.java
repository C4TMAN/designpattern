package com.c4tman.play.design.pattern.factory.service.impl;

import com.c4tman.play.design.pattern.factory.service.Shape;

/**
 * Created by zhangxiaoman on 2018/6/27.
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("🔺");
    }
}
