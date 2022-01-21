package com.santosh.springaop.service;

import com.santosh.springaop.annotations.ShapeType;
import org.springframework.stereotype.Component;

@ShapeType(ShapeType.ShapeOption.SQUARE)
@Component
public class Square implements Shape {
    private int length;

    @Override
    public void setParameter(int param) {
        this.length = param;
    }

    @Override
    public double area() {
        return this.length * this.length;
    }

    @Override
    public void applyColor(String color) {
        System.out.println("Color " + color + " applied to shape");
    }
}
