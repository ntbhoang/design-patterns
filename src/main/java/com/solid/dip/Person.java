package com.solid.dip;


import java.util.ArrayList;
import java.util.List;

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}


public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Introduce abstraction to the class
interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

// Old class
class Relationships {
    // low-level module
    // It is low level because it is dealing with storage and retrieval of data
    // It is not dealing with the business logic
    // It only gives us the access to the data
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
}

// New class
class RelationshipAbs implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> x.getValue0().getName().equals(name) && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .toList();
    }
}


class Research {
    // high-level module
    // It is high level because it is dealing with the business logic
    // It is not dealing with the storage and retrieval of data
    // It only uses the data

    // Old method
    public Research(Relationships relationships) {
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().getName().equals("John") && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().getName()));
    }

    // New method
    public Research(RelationshipAbs relationships) {
        List<Person> children = relationships.findAllChildrenOf("John");
        for (Person child : children) {
            System.out.println("John has a child called " + child.getName());
        }
    }
}
