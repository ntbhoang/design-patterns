package com.patterns.creational.factories.abstract_factory;

// Step1: Define abstract factory interface
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// Step2: Define concrete factories
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

class VintageFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VintageChair();
    }

    @Override
    public Sofa createSofa() {
        return new VintageSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VintageCoffeeTable();
    }
}

// Step3: Define abstract product interfaces
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

interface CoffeeTable {
    void putCoffee();
}

// Step4: Define concrete products
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on modern chair");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on modern sofa");
    }
}

class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void putCoffee() {
        System.out.println("Putting coffee on modern coffee table");
    }
}

class VintageChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on vintage chair");
    }
}

class VintageSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on vintage sofa");
    }
}

class VintageCoffeeTable implements CoffeeTable {
    @Override
    public void putCoffee() {
        System.out.println("Putting coffee on vintage coffee table");
    }
}

// Step5: Use the factory
public class Furniture {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable coffeeTable = factory.createCoffeeTable();

        chair.sitOn();
        sofa.lieOn();
        coffeeTable.putCoffee();
    }
}


