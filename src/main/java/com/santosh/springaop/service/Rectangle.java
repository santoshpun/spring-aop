package com.santosh.springaop.service;

import com.santosh.springaop.annotations.ShapeType;
import org.springframework.stereotype.Component;

@ShapeType(ShapeType.ShapeOption.RECTANGLE)
@Component
public class Rectangle implements Shape {
    private int length;
    private int width;

    @Override
    public void setParameter(int param) {
        this.length = param;
        this.width = param;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }

    @Override
    public void applyColor(String color) {
        System.out.println("Color " + color + " applied to shape");
    }
}
