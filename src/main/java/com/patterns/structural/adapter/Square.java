package com.patterns.structural.adapter;

interface Rectangle {
    int getWidth();
    int getHeight();

    default int getArea() {
        return getWidth() * getHeight();
    }
}

// Step 2: define adapter class
class SquareToRectangleAdapter implements Rectangle {

    private final Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getArea() {
        return square.getArea();
    }

    @Override
    public int getWidth() {
        return square.getSide();
    }

    @Override
    public int getHeight() {
        return square.getSide();
    }
}

// Try to define a SquareToRectangleAdapter that adapts the Square  to the IRectangle  interface.

public class Square {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public int getArea() {
        return side * side;
    }
}

class DemoApp {
    public static void main(String[] args) {
        SquareToRectangleAdapter str = new SquareToRectangleAdapter(new Square(5));
        System.out.println(str.getArea());

    }
}
