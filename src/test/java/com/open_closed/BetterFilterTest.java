package com.open_closed;

import com.solid.open_closed.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BetterFilterTest {
    @Test
    void testFilterByColor() {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.HUGE);

        List<Product> products = List.of(apple, tree, house);

        BetterFilter bf = new BetterFilter();
        List<Product> result = bf.filter(products, new ColorSpecification(Color.RED)).toList();
        assertEquals(1, result.size());
        assertEquals("Apple", result.get(0).name);
    }

    @Test
    void testFilterBySize() {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.HUGE);

        List<Product> products = List.of(apple, tree, house);

        BetterFilter bf = new BetterFilter();
        List<Product> result = bf.filter(products, new SizeSpecification(Size.LARGE)).toList();
        assertEquals(1, result.size());
        assertEquals("Tree", result.get(0).name);
    }

    @Test
    void testFilterBySizeAndColor() {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.HUGE);

        List<Product> products = List.of(apple, tree, house);

        BetterFilter bf = new BetterFilter();
        List<Product> result = bf.filter(products, new ColorAndSizeSpecification<>(new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.HUGE)))
                .toList();
        assertEquals(1, result.size());
        assertEquals("House", result.get(0).name);
    }
}
