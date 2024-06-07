package com.patterns.creational.singleton.testability;

import java.util.List;

public class ConfigurableRecordFinder {
    private Database database;

    public ConfigurableRecordFinder(Database database) {
        this.database = database;
    }

    public int getTotalPopulation(List<String> names) {
        int result = 0;
        for (String name : names) {
            // Now, instead of depending on the SingletonDatabase class, we depend on the Database interface.
            // We can inject any database that implements the Database interface, like dummy databases, in-memory databases, etc.
            result += database.getPopulation(name);
        }
        return result;
    }
}
