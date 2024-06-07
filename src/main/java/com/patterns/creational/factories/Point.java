package com.patterns.creational.factories;


enum CoordinateSystem {
    CARTESIAN,
    POLAR
}


public class Point {
    private double x, y;

    // This is so ugly, and we're probably branching a lot more when the rule changes
    private Point(double x, double y, CoordinateSystem cs) {
        if (cs.equals(CoordinateSystem.CARTESIAN)) {
            this.x = x;
            this.y = y;
        } else {
            this.x = x * Math.cos(y);
            this.y = x * Math.sin(y);
        }
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y, CoordinateSystem.CARTESIAN);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho, theta, CoordinateSystem.POLAR);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Demo {
    public static void main(String[] args) {
        Point point = Point.newCartesianPoint(2, 3);
        System.out.println(point);

        Point point2 = Point.newPolarPoint(2, 3);
        System.out.println(point2);
    }
}
