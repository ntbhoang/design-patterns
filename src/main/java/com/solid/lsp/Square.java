package com.solid.lsp;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    // Liskov Substitution Principle is violated here
    // because the Square class is not a subclass of Rectangle
    // and the Square class does not have the same behavior as the Rectangle class
    // so the Square class should not inherit from the Rectangle class
    // and the Rectangle class should not be used in the useIt method
}
