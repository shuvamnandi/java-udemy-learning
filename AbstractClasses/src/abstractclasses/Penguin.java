package abstractclasses;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println( getName() + " says: I'm not very good at that, will go for a swim instead");
    }
}
