package com.shuvam.learning;

public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = "+publicVar + ": varone = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        int varTwo = 2; // if this is committed, privateVar from Class is used
        // If this method was a static method, privateVar cannot be accessed from within this method as it is not defined as static
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times 2 is " + i * varTwo);
            // System.out.println(i + " times 2 is " + i * varOne);
        }
        // System.out.println("Value of i is" + i); // This does not work, i is not available in this scope
    }

    // The containing class can also access all the methods and variables of a contained class, even if they're
    // marked as private. The same is true the other way around.
    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("Using innerClass.varThree: "+ innerClass.varThree);
    }

    public class InnerClass {
        // The object scope is the block in which it is declared, including any contained blocks.
        private int varThree = 3; // if this is commented out, it uses privateVar from ScopeCheck, which has a value of 1
        // The containing class can also access all the methods and variables of a contained class, even if they're
        // marked as private. The same is true the other way around.
        // However, it is not accessible anywhere outside of here.

        public InnerClass() {
            System.out.println("InnerClass created, varOne is " + varOne + ", varThree is " + varThree);
        }

        public void timesTwo() {
            for (int i = 0; i < 10; i++) {
                // ScopeCheck.this.timesTwo(); // call method defined inside ScopeCheck class's object (since it is not a static method, we need to use this keyword)
                // System.out.println(i + " times 3 is " + i * ScopeCheck.this.privateVar); // Access the privateVar defined inside ScopeCheck class
                System.out.println(i + " times 3 is " + i * varThree); // This  would cause an issue if varThree is not declared inside the InnerClass scope
            }
        }

    }

}
