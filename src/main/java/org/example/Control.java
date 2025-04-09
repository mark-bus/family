package org.example;

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
        parent1.addChild(child1, child2, child3);
        parent3.addChild(child4);

        List<Parent> parents = List.of(parent1, parent2, parent3, parent4);
        List<Person> people = collectPeople(parents);
    }

    private List<Person> collectPeople(List<Parent> parents) {
        Stream<Person> childStream = parents.stream()
                .flatMap(parent -> parent.getChildren().stream());
        return Stream.concat(parents.stream(), childStream)
                .toList();
    }

}
