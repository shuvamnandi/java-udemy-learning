package com.shuvam.learning;

public class Main {

    public static void main(String[] args) {
        String privateVar = "this is private to main()";
        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("ScopeCheck.publicVar is: " + scopeCheck.publicVar);
        System.out.println("ScopeCheck.privateVar is: " + scopeCheck.getPrivateVar());
        // System.out.println("ScopeCheck.privateVar is: " + scopeCheck.privateVar); // this does not work
        System.out.println("privateVar is: " + privateVar);
        scopeCheck.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        innerClass.timesTwo();

    }
}
