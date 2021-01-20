package com.shuvam.learning;

public class Main {

    public static void main(String[] args) {
        //
	    FinalTest one = new FinalTest("one");
        FinalTest two = new FinalTest("two");
        FinalTest three = new FinalTest("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        // Math math = new Math();
        // Constructor is made private to not allow any instances created
        // Math classes is marked as final, which prevents the class from being sub-classed
        // Any method marked as final prevents the method from being overridden

        Password password = new ExtendedPassword(634231214);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(5213231);
        password.letMeIn(9712);
        password.letMeIn(63423214);
        password.letMeIn(634231214);

        SIBTest sibTest = new SIBTest();
        sibTest.someMethod();
    }
}
