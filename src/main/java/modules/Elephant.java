package modules;

public class Elephant extends Animal {
    private int totalChildren;

    public Elephant(String name, int age, int totalChildren) {
        super(name, age);
        this.totalChildren = totalChildren;
    }

    public int getTotalChildren() {
        return totalChildren;
    }

    public void setTotalChildren() {
        this.totalChildren = totalChildren;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + ", name: " + getName() + ", age: " + getAge() + ", Total Children: " + getTotalChildren();
    }
}