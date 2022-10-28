package modules;

public abstract class Animal {
    private final int ID;
    private String name;
    private int age;
    private static int animalCounter;

    public Animal(String name, int age) {
        this.ID = 100 + ++animalCounter;
        this.name = name;
        this.age = age;
    }

    public final int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + ", name: " + getName() + ", age:" + getAge();
    }
}
