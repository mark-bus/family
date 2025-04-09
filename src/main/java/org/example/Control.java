package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Control {

    public Control() {
        Child child1 = new Child("Gyerek1", 1, "gyerek1@gyerek.hu");
        Child child2 = new Child("Gyerek2", 2, "gyerek2@gyerek.hu");
        Child child3 = new Child("Gyerek3", 3, "gyerek3@gyerek.hu");
        Child child4 = new Child("Gyerek4", 4, "gyerek4@gyerek.hu");
        Parent parent1 = new Parent("Szülő1", 21, "szulo1@szulo.hu");
        Parent parent2 = new Parent("Szülő2", 22, "szulo2@szulo.hu");
        Parent parent3 = new Parent("Szülő3", 23, "szulo3@szulo.hu");
        Parent parent4 = new Parent("Szülő4", 24, "szulo4@szulo.hu");
        List<Parent> parents = new ArrayList<>();
        parent1.addChild(child1);
        parent1.addChild(child2);
        parent1.addChild(child3);
        parent3.addChild(child4);
        parents.add(parent1);
        parents.add(parent2);
        parents.add(parent3);
        parents.add(parent4);

        List<Person> people = collectParentsAndChildren(parents);
    }

    private List<Person> collectParentsAndChildren(List<Parent> parents) {
        Stream<Person> childStream = parents.stream()
                .flatMap(parent -> parent.getChildren().stream());
        return Stream.concat(parents.stream(), childStream)
                .toList();
    }

}
