package com.c4tman.play.design.pattern.factory;

import com.c4tman.play.design.pattern.factory.service.Shape;
import com.c4tman.play.design.pattern.factory.service.impl.Circle;
import com.c4tman.play.design.pattern.factory.service.impl.Triangle;
import com.c4tman.play.design.pattern.factory.service.impl.Square;

/**
 * Created by zhangxiaoman on 2018/6/27.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Triangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
