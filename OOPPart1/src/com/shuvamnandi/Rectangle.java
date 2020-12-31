package com.shuvamnandi;

public class Rectangle {
    private double length;
    private double width;

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public Rectangle(double width, double length) {
        this.width = width > 0 ? width : 0;
        this.length = length > 0 ? length : 0;
    }

    public double getArea() {
        return this.length * this.width;
    }

}
