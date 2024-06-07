package com.solid.srp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Journal {

    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add(++count + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    // In the future, we might want to save the journal to a file
    // or load it from a file. So, we can add these methods here.
    public void save(String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Load content from a file
    public void load(String filename) {}
    // Load content form an url
    public void load(URL url) {}

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

// Add a Persistance class to handle saving and loading of the journal
class Persistance {
    public void saveToFile(Journal journal, String filename, boolean overwrite) {
        if (overwrite || new java.io.File(filename).exists()) {
            try (PrintWriter out = new PrintWriter(filename)) {
                out.println(journal.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Journal load(String filename) {
        return null;
    }
}




class Demo {
    public static void main(String[] args) {
        Journal journal = new Journal();
        journal.addEntry("I cried today");
        journal.addEntry("I ate a bug");
        System.out.println(journal);
    }
}