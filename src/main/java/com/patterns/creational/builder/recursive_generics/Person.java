package com.patterns.creational.builder.recursive_generics;

public class Person {

    private String name;
    private int age;
    private String position;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    static class PersonBuilder<SELF extends PersonBuilder<SELF>> {

        protected final Person person = new Person();

        public SELF withName(String name) {
            person.name = name;
            return self();
        }

        public SELF withAge(int age) {
            person.age = age;
            return self();
        }

        public SELF withPosition(String position) {
            person.position = position;
            return self();
        }

        public SELF withAddress(String address) {
            person.address = address;
            return self();
        }

        public Person build() {
            return person;
        }

        protected SELF self() {
            return (SELF) this;
        }
    }


    static class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
        public EmployeeBuilder worksAt(String position) {
            person.position = position;
            return self();
        }

        @Override
        protected EmployeeBuilder self() {
            return this;
        }
    }
}


class Demo {
    public static void main(String[] args) {
        Person.EmployeeBuilder eb = new Person.EmployeeBuilder();
        eb.withName("Max")
                .withAge(39)
                .worksAt("Quality Engineering Manager")
                .withAddress("Hill St, City")
                .build();

        Person.PersonBuilder pb = new Person.PersonBuilder();
        pb.withName("Max")
                .withAge(39)
                .withPosition("Quality Engineering Manager")
                .withAddress("Hill St, City")
                .build();

        System.out.println(eb);
        System.out.println(pb);
    }
}
