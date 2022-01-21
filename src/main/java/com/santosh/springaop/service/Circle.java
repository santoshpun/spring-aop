package com.santosh.springaop.service;

import com.santosh.springaop.annotations.ShapeType;
import org.springframework.stereotype.Component;

@ShapeType(ShapeType.ShapeOption.CIRCLE)
@Component
public class Circle implements Shape {
    private int radius;

    @Override
    public void setParameter(int param) {
        this.radius = param;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void applyColor(String color) {
        System.out.println("Color " + color + " applied to shape");
    }
}
