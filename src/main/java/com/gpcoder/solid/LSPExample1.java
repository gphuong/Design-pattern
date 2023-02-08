package com.gpcoder.solid;

class Rectangle {
    private int width;
    private int height;

    public int calculateArea() {
        return this.width * this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setHeight(height);
    }
}

public class LSPExample1 {
    public void example1() {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println(rect.calculateArea());

        Square square = new Square();
        square.setWidth(5);
        square.setHeight(10);
        System.out.println(square.calculateArea());
    }

    public void example2() {
        Rectangle rect = new Square();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println(rect.calculateArea());
    }
}
