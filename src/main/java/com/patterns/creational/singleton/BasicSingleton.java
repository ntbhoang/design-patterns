package com.patterns.creational.singleton;

import java.io.*;
import java.util.function.Supplier;

public final class BasicSingleton implements Serializable{
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private int value = 0;

    private BasicSingleton() {
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}


class SingletonTester
{
    public static boolean isSingleton(Supplier<Object> func) {
        return func.get() == func.get();
    }
}


class Demo {
    static void saveToFile(BasicSingleton singleton, String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }


    static BasicSingleton readFromFile(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);
        saveToFile(singleton, "singleton.bin");

        // Set another value
        singleton.setValue(222);
        var singleton2 = readFromFile("singleton.bin");
        System.out.println(singleton.equals(singleton2));
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }



}
