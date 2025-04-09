package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Parent extends Person {

    private List<Child> children;

    public Parent(String name, int age, String email) {
        super(name, age, email);
    }

    public void addChild(Child... children) {
        Child[] childArray = Objects.requireNonNull(children);
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.addAll(List.of(childArray));
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Child> getChildren() {
        return children == null ? Collections.emptyList() : children;
    }

}
