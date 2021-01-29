package com.shuvamnandi;

public class Account {
    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING=1;
    public static final int SAVINGS=2;

    private int accountType;
    public Account(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public double deposit(double amount, boolean branc) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }
}
