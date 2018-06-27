package com.c4tman.play.design.pattern.factory;

import com.c4tman.play.design.pattern.factory.service.Shape;

/**
 * Created by zhangxiaoman on 2018/6/27.
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
