package com.solid.isp;

public class Document {

}


interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

// Segregated interfaces
interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

interface Fax {
    void fax(Document d);
}

// JustAPrinter class is only interested in printing
// YAGNI - You Ain't Gonna Need It principle
class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {
        // print
    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {
        // print
    }

    @Override
    public void scan(Document d) {
        // scan
    }
}


class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {
        // print
    }

    @Override
    public void fax(Document d) {
        // fax
    }

    @Override
    public void scan(Document d) {
        // scan
    }
}


class OldFashionedPrinter implements Machine {
    @Override
    public void print(Document d) {
        // print
    }

    @Override
    public void fax(Document d) {
        throw new UnsupportedOperationException("Fax not supported");
    }

    @Override
    public void scan(Document d) {
        throw new UnsupportedOperationException("Scan not supported");
    }
}