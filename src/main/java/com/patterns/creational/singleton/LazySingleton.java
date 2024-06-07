package com.patterns.creational.singleton;

import java.util.Objects;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Singleton is initializing");
    }

    public static LazySingleton getInstance() {
        // This is not thread-safe
        // If two threads call this method at the same time, two instances will be created

        if (Objects.isNull(instance)) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getInstanceDoubleLocking() {
        // This outdated approach
        if (Objects.isNull(instance)) {
            synchronized (LazySingleton.class) {
                if (Objects.isNull(instance)) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

class LazySingletonDemo {
    public static void main(String[] args) {
        LazySingleton singleton = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}
