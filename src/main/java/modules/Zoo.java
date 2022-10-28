package modules;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private ArrayList<Animal> animalsInPark = new ArrayList<>();

    public Zoo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Animal> getAnimalsInPark() {
        return new ArrayList<Animal>(animalsInPark);
    }

    public void addAnimalToPark(Animal anAnimal) {
        animalsInPark.add(anAnimal);
    }
}
