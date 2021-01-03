package abstractclasses;

public class Main {
    // TODO: Complete code for challenge on Inner Classes and Abstract Classes
    public static void main(String[] args) {
        Animal dog = new Dog("Tommy");
        dog.eat();
        dog.breathe();
        Bird parrot = new Parrot("Mitthu");
        parrot.eat();
        parrot.breathe();
        parrot.fly();
        Bird penguin = new Penguin("Emperor");
        penguin.eat();
        penguin.breathe();
        penguin.fly();
    }
}
