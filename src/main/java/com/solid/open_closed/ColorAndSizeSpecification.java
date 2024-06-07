package com.solid.open_closed;

// Create color and size specification classes that implement the Specification interface
public class ColorAndSizeSpecification<T> implements Specification<T> {
    private final Specification<T> first;
    private final Specification<T> second;

    public ColorAndSizeSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}
