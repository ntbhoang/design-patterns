package com.patterns.creational.builder.faceted;


/* Sometime, the object is so complex so we have to use multiple builders

 */
public class Person {
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}


class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person max = pb.lives()
                .at("123 London Road").in("London")
                .withPostcode("SW12BC")
                .works()
                .at("Property Guru VN")
                .asA("QA Manager")
                .earning(123000)
                .build();

        System.out.println(max);
    }
}
