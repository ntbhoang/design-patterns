package com.solid.lsp;

public class LSPDemo {
    public static void main(String[] args) {

        useIt(new Rectangle(2, 3));

        useIt(new Square(5));

    }

    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.calculateArea());
    }
}
