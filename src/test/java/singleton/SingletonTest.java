package singleton;

import com.patterns.creational.singleton.testability.ConfigurableRecordFinder;
import com.patterns.creational.singleton.testability.DummyDatabase;
import com.patterns.creational.singleton.testability.SingletonDatabase;
import com.patterns.creational.singleton.testability.SingletonRecordFinder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonTest {

    /*
        * This test is to check if the SingletonDatabase class is working as expected.
        * The problem with the SingletonDatabase class is that it is not testable.
        * The test has dependencies on the actual database, which makes the test slow and violates the unit test principle.
        * The test also violates the dependency inversion principle, should depends on abstraction instead of low level db

        * The implementation of the SingletonDatabase class is as follows:
        * - It has a private constructor that initializes the capitals dictionary with the population of some cities.
        * - When we want to test the SingletonDatabase class, we can't use the actual database because it will make the test slow.
        * - We can't mock the SingletonDatabase class because it is a singleton.
        * - We can't use a subclass of SingletonDatabase because the constructor is private.
        * - We can't use a factory because the factory will create a new instance of the SingletonDatabase class.
        * - We can't use a static method because the static method will create a new instance of the SingletonDatabase class.
        * - We can't use a DI framework because the SingletonDatabase class is a singleton.
        *
        *

     */
    @Test
    void isSingletonTest() {
        SingletonRecordFinder srf = new SingletonRecordFinder();
        // If the SingletonDatabase class is changed, the test will fail.
        // For example, if Seoul is changed to Ho Chi Minh
        List<String> names = List.of("Seoul", "Tokyo", "Moscow");
        int tp = srf.getTotalPopulation(names);
        assertEquals(9733509 + 13929286 + 11920000, tp);
    }

    @Test
    void dependentPopulationTest() {
        DummyDatabase dummyDb = new DummyDatabase();
        ConfigurableRecordFinder cf = new ConfigurableRecordFinder(dummyDb);
        assertEquals(3, cf.getTotalPopulation(List.of("alpha", "beta")));

    }
}
