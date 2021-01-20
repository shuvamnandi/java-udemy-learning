package com.shuvam.learning;

public class Main {
    public static void main(String[] args) {
        String varFour = "this is private to main()";
        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("ScopeCheck.publicVar is: " + scopeCheck.publicVar);
        System.out.println("ScopeCheck.varOne is: " + scopeCheck.getVarOne());
        // System.out.println("ScopeCheck.privateVar is: " + scopeCheck.privateVar); // this does not work
        System.out.println("varFour is: " + varFour);
        scopeCheck.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        innerClass.timesTwo();
        scopeCheck.useInner();
        // System.out.println("innerClass.varThree" + innerClass.varThree); // This does not work as varThree is private

    }
}
