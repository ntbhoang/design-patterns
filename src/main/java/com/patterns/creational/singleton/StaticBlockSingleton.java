package com.patterns.creational.singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    // Static block is similar to eager initialization, it gives you option for exception handling
    // If you have an idea of class loading sequence,
    // you can use the fact that static blocks are executed during the loading of a class, even before the constructor is called.
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (IOException e) {
            System.err.println("Failed to create singleton");
        }
    }

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".....", ".");
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

class DemoStaticBlockSingleton {
    public static void main(String[] args) {
        StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
        StaticBlockSingleton singleton2 = StaticBlockSingleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}
