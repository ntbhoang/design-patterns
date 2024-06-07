package com.solid.open_closed;

import java.util.List;
import java.util.stream.Stream;


public class Product {

    public String name;
    Color color;
    Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}


// You want to filter products based on color, size, both, etc.
class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
    // Now, the requirement is changed to filter by both size and color at the same time
    // You have to modify the ProductFilter class to add a new method filterBySizeAndColor
    // This violates the Open-Closed Principle
    // The class should be open for extension but closed for modification
    // Imagine if the Product class has more attributes, you have to add more methods to filter by those attributes
}

// The solution is to create a new interface that has a single method to filter products: Specification pattern
interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}


class Demo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.HUGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        pf.filterByColor(products, Color.RED).forEach(p -> System.out.println(" - " + p.name + " is red"));

        // create better filter
        BetterFilter bf = new BetterFilter();
        bf.filter(products, new ColorSpecification(Color.BLUE)).forEach(p -> System.out.println(" - " + p.name + " is blue"));
        // filter by size
        bf.filter(products, new SizeSpecification(Size.LARGE)).forEach(p -> System.out.println(" - " + p.name + " is large"));
        // filter by size and color
        bf.filter(products, new ColorAndSizeSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.HUGE)))
                .forEach(p -> System.out.println(" - " + p.name + " is blue and huge"));
    }
}


