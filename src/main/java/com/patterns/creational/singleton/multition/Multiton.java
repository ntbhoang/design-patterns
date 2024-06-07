package com.patterns.creational.singleton.multition;


/*
    * Multiton is a design pattern which allows you to have only a fixed number of instances of a class.
    * For every instance, you can assign a key and based on that key you can get the instance.
    * This pattern is a variation of Singleton pattern.
 */

import java.util.HashMap;

enum Subsystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}


class Printer {
    private static final HashMap<Subsystem, Printer> instances = new HashMap<>();
    private static int instancesCount = 0;

    private Printer() {
        instancesCount++;
        System.out.println("A total of " + instancesCount + " instances created so far.");
    }

    public static Printer get(Subsystem subsystem) {
        if (instances.containsKey(subsystem)) {
            return instances.get(subsystem);
        }
        Printer instance = new Printer();
        instances.put(subsystem, instance);

        return instance;
    }
}


public class Multiton {
    public static void main(String[] args) {
        Printer primary = Printer.get(Subsystem.PRIMARY);
        Printer auxiliary = Printer.get(Subsystem.AUXILIARY);
        Printer fallback = Printer.get(Subsystem.FALLBACK);

        Printer primary2 = Printer.get(Subsystem.PRIMARY);

        System.out.println(primary == primary2);
    }
}
