package com.patterns.creational.singleton.testability;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;


interface Database {
    int getPopulation(String name);
}


public class SingletonDatabase implements Database{

    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanceCount = 0;

    private static int getCount() {
        return instanceCount;
    }

    private SingletonDatabase() {
        instanceCount++;
        System.out.println("Initializing database");

        capitals.put("Seoul", 9733509);
        capitals.put("Tokyo", 13929286);
        capitals.put("Washington, D.C.", 702455);
        capitals.put("Berlin", 3748148);
        capitals.put("Moscow", 11920000);
        capitals.put("Jakarta", 10187595);
        capitals.put("Beijing", 21500000);
        capitals.put("New Delhi", 16787941);
        capitals.put("Cairo", 11893000);
        capitals.put("London", 8908081);
        capitals.put("Brasília", 3015268);
    }

    private static final SingletonDatabase INSTANCE = new SingletonDatabase();

    public static SingletonDatabase getInstance() {
        return INSTANCE;
    }

    public int getPopulation(String name) {
        return capitals.get(name);
    }
}


