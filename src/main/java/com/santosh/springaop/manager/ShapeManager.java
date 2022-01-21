package com.santosh.springaop.manager;

import com.santosh.springaop.annotations.ShapeType;
import com.santosh.springaop.service.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShapeManager {
    @Autowired
    @ShapeType(ShapeType.ShapeOption.CIRCLE)
    private Shape circle;

    @Autowired
    @ShapeType(ShapeType.ShapeOption.SQUARE)
    private Shape square;

    public void perform(){
        circle.setParameter(2);
        System.out.println(circle.area());
        circle.applyColor("RED");

        square.setParameter(500);
        System.out.println(square.area());
        square.applyColor("BLUE");

    }
}
