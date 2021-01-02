package abstractclasses;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog->eat");
    }

    @Override
    public void breathe() {
        System.out.println("Dog->breathe");
    }
}
