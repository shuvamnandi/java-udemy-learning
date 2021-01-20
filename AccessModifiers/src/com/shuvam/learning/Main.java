package com.shuvam.learning;

public class Main {

    /*
    Top Level
    Public means that the object is visible to all classes everywhere, whether they are in the same package or have
    imported the package containing the public class.

    Package-private means that it something is accessible within its own package and is visible to every class
    within the same package. So package-private is specified by not specifying any access modifier.
    In other words, instead of default, if you do not specify public, that implies package-private.
    There is no package-private key word as such.

    Private top level classes/interfaces/enum declarations are not allowed.

    Member Level
    A public class member or field and public method can be accessed from any other class anywhere,
    even in a different package.

    An object with no access modifier (i.e. package-private) is visible to every class within the same package
    but not to classes in external packages.

    A private object is only visible within the class it's declared in, and in classes
    containing that class or in classes contained by that class. It's not visible anywhere else, including in
    subclasses of its class.

    A protected object is visible anywhere in its own package, sort of like package-private, but also in subclasses,
    even if they were in another package.
     */
    public static void main(String[] args) {
        Account account = new Account("Shuvam");
        account.deposit(100);
        account.deposit(600);
        account.withdraw(500);
        account.deposit(700);
        account.withdraw(3000);
        account.calculateBalance();

        // allowed right now as balance is declared as public, this can cause fraud
        // declaring them private is required
        // account.balance += 500;
        account.calculateBalance();
        // account.transactions.add(500);
        account.calculateBalance();
    }
}
