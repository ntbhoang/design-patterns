package com.patterns.structural.decorator;

interface Shape {
    String info();
}

class Circle implements Shape {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square(float side) {
        this.side = side;
    }

    void resize(float factor) {
        side *= factor;
    }

    @Override
    public String info() {
        return "A square with side " + side;
    }
}

/*
    Let's say we want to add color to our shapes.
    We can create a new class for that, but that would be a lot of classes.
    Instead, we can use the decorator pattern.
    We can create a new class that will take a shape and add color to it.
    This way, we can add color to any shape we want.
 */

class ColoredShape implements Shape {
    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

class Demo {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape blueSquare = new ColoredShape(new Square(20), "blue");
        System.out.println(blueSquare.info());

        TransparentShape transparentCircle = new TransparentShape(new Circle(5), 50);
        System.out.println(transparentCircle.info());
    }
}


