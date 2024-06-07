package com.patterns.structural.decorator;

interface Car {
    void assemble();
}

// 2 car type implementations
class RealCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Assembling a real car");
    }
}

class ToyCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling a toy car");
    }
}

// Create an abstract CarDecorator class
abstract class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}

// Concrete decorator classes
class ElectricCarDecorator extends CarDecorator {

    public ElectricCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding an electric engine to the car");
    }
}

class FlyingCarDecorator extends CarDecorator {

    public FlyingCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding wings to the car");
    }
}

class CarDemo {
    public static void main(String[] args) {
        Car toyCar = new ToyCar();
        toyCar.assemble();
        System.out.println("-----");

        Car electricToyCar = new ElectricCarDecorator(new ToyCar());
        electricToyCar.assemble();
        System.out.println("-----");

        Car flyingElectricToyCar = new FlyingCarDecorator(new ElectricCarDecorator(new ToyCar()));
        flyingElectricToyCar.assemble();
        System.out.println("-----");

        Car realCar = new RealCar();
        realCar.assemble();
        System.out.println("-----");

        Car electricRealCar = new ElectricCarDecorator(new RealCar());
        electricRealCar.assemble();
        System.out.println("-----");

        Car flyingElectricRealCar = new FlyingCarDecorator(new ElectricCarDecorator(new RealCar()));
        flyingElectricRealCar.assemble();
    }
}

