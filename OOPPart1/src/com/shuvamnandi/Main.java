package com.shuvamnandi;

public class Main {

    public static void classExamples() {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4.0);
        System.out.println("Add= " + calculator.getAdditionResult());
        System.out.println("Subtract= " + calculator.getSubtractionResult());
        System.out.println("Multiply= " + calculator.getMultiplicationResult());
        System.out.println("Divide= " + calculator.getDivisionResult());
        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0.0);
        System.out.println("Add= " + calculator.getAdditionResult());
        System.out.println("Subtract= " + calculator.getSubtractionResult());
        System.out.println("Multiply= " + calculator.getMultiplicationResult());
        System.out.println("Divide= " + calculator.getDivisionResult());
        Person person = new Person();
        person.setFirstName("");   // firstName is set to empty string
        person.setLastName("");    // lastName is set to empty string
        person.setAge(10);
        System.out.println("fullName= " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        person.setFirstName("John");    // firstName is set to John
        person.setAge(18);
        System.out.println("fullName= " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        person.setLastName("Smith");    // lastName is set to Smith
        System.out.println("fullName= " + person.getFullName());
    }

    public static void constructorExamples(){
        Account emptyAccount = new Account();
        Account bobsAccount = new Account("121321", 10);
        emptyAccount.withdraw(10);
        bobsAccount.withdraw(20);
        bobsAccount.deposit(30);
        bobsAccount.withdraw(20);
        System.out.println(bobsAccount.toString());

        VipPerson vipPerson = new VipPerson();
        System.out.println("Name: "+vipPerson.getName());
        System.out.println("Limit: "+vipPerson.getCreditLimit());
        System.out.println("Email: "+vipPerson.getEmailAddress());

        VipPerson vipPerson1 = new VipPerson("Bob", 20000);
        System.out.println("Name: "+vipPerson1.getName());
        System.out.println("Limit: "+vipPerson1.getCreditLimit());
        System.out.println("Email: "+vipPerson1.getEmailAddress());

        VipPerson vipPerson2 = new VipPerson("GV", 100000, "gv@mail.goole.com");
        System.out.println("Name: "+vipPerson2.getName());
        System.out.println("Limit: "+vipPerson2.getCreditLimit());
        System.out.println("Email: "+vipPerson2.getEmailAddress());

        Wall wall = new Wall(5,4);
        System.out.println("area= " + wall.getArea());
        wall.setHeight(-1.5);
        System.out.println("width= " + wall.getWidth());
        System.out.println("height= " + wall.getHeight());
        System.out.println("area= " + wall.getArea());

        Point a = new Point();
        Point b = new Point(4,3);
        Point c = new Point(2,3);
        System.out.println("a.distance() = " + a.distance());
        System.out.println("b.distance() = " + b.distance());
        System.out.println("b.distance(c.x, c.y) = " + b.distance(c.getX(), c.getY()));
        System.out.println("b.distance(c) = " + b.distance(c));

        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4.0);
        Calculator calculator = new Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());
        carpet = new Carpet(1.5);
        floor = new Floor(5.4, 4.5);
        calculator = new Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());

        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        one.subtract(number);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        number.subtract(one);
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());
    }

    public static void inheritanceExamples(){
        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 20, 1, "Thick Silky");
        animal.eat();
        animal.move(2);
        dog.eat();
        dog.walk();
        dog.run();

        FerrariCar ferrariCar = new FerrariCar("Red", "4WD", "SUV", 24);
        ferrariCar.steer(30);
        ferrariCar.accelerate(10);
        ferrariCar.steer(0);
        ferrariCar.accelerate(40);

        Circle circle = new Circle(3.75);
        System.out.println("circle.radius= " + circle.getRadius());
        System.out.println("circle.area= " + circle.getArea());
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("cylinder.radius= " + cylinder.getRadius());
        System.out.println("cylinder.height= " + cylinder.getHeight());
        System.out.println("cylinder.area= " + cylinder.getArea());
        System.out.println("cylinder.volume= " + cylinder.getVolume());

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth());
        System.out.println("rectangle.length= " + rectangle.getLength());
        System.out.println("rectangle.area= " + rectangle.getArea());
        Cuboid cuboid = new Cuboid(5,10,5);
        System.out.println("cuboid.width= " + cuboid.getWidth());
        System.out.println("cuboid.length= " + cuboid.getLength());
        System.out.println("cuboid.area= " + cuboid.getArea());
        System.out.println("cuboid.height= " + cuboid.getHeight());
        System.out.println("cuboid.volume= " + cuboid.getVolume());
    }

    public static void main(String [] args) {
        // Main.classExamples();
        // Main.constructorExamples();
        Main.inheritanceExamples();
    }
}
