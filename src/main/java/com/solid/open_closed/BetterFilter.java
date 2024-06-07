package com.solid.open_closed;

import java.util.List;
import java.util.stream.Stream;

// Create a new class that implements the Filter interface
public class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(spec::isSatisfied);
    }
}
