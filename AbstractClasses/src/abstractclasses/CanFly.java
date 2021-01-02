package abstractclasses;

public interface CanFly {
    void fly();
    /*
    Differences between abstract classes and interfaces
    1. In abstract classes, methods can be private, protected or public. Methods in interfaces are public by default.
    2. In abstract classes, member variables can be defined. Variables in interfaces can be defined but can only be
    public static final, i.e. constant values with a static scope
    as non-static variables require an instance, and an interface cannot be instantiated.
    3. Abstract classes can have constructors, while interfaces cannot.
    4. Abstract classes can have methods with an implementation, while interfaces cannot. All methods are to be defined
    in the class implementing the interface.
     */
}
