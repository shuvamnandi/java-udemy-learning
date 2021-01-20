package com.shuvam.learning;

public class Main {

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
