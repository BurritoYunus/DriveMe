package modules;

public class Dolphin extends Animal {
    private int iq;


    public Dolphin(String name, int age, int iq) {
        super(name, age);
       this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + ", name: " + getName() + ", age: " + getAge() + ", IQ: " + getIq();
    }
}


