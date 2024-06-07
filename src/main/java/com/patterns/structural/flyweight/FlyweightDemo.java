package com.patterns.structural.flyweight;

import java.awt.*;
import java.util.EnumMap;
import java.util.HashMap;

interface Shape {
    void draw(Graphics g, int x, int y, int width, int height);
}

// Concrete class Line
class Line implements Shape {
    public Line() {
        System.out.println("Creating Line object");
        // Adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.RED);
        g.drawLine(x, y, width, height);
    }
}

class Oval implements Shape {
    private boolean fill;

    public Oval(boolean fill) {
        this.fill = fill;
        System.out.println("Creating Oval object with fill=" + fill);
        // Adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GREEN);
        if (fill) {
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }
}

// Flyweight factory
class ShapeFactory {
    private static final EnumMap<ShapeType, Shape> shapes = new EnumMap<>(ShapeType.class);

    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.computeIfAbsent(type, k -> {
            if (type.equals(ShapeType.OVAL_FILL)) {
                return new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NO_FILL)) {
                return new Oval(false);
            } else {
                return new Line();}
        });
        shapes.put(type, shapeImpl);

        return shapeImpl;
    }

    public enum ShapeType{
        OVAL_FILL,OVAL_NO_FILL,LINE;
    }
}

class Demo {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape(ShapeFactory.ShapeType.OVAL_FILL);
        shape1.draw(new Canvas().getGraphics(), 10, 10, 100, 100);

        Shape shape2 = ShapeFactory.getShape(ShapeFactory.ShapeType.OVAL_NO_FILL);
        shape2.draw(new Canvas().getGraphics(), 10, 10, 100, 100);

        Shape shape3 = ShapeFactory.getShape(ShapeFactory.ShapeType.LINE);
        shape3.draw(new Canvas().getGraphics(), 10, 10, 100, 100);

        Shape shape4 = ShapeFactory.getShape(ShapeFactory.ShapeType.LINE);
        shape4.draw(new Canvas().getGraphics(), 10, 10, 100, 100);
    }
}

