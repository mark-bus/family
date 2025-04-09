package org.example;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Person {

    private final List<Child> children = new ArrayList<>();

    public Parent(String name, int age, String email) {
        super(name, age, email);
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public List<Child> getChildren() {
        return children;
    }
    
}
