package com.shuvam.learning;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance now is : " + this.balance);
        }
        else {
            System.out.println("Cannot deposit amount of: " + amount);
        }
    }

    public void withdraw(int amount) {
        int withdrawAmount = -amount;
        if (withdrawAmount < 0 && (balance + withdrawAmount >= 0)) {
            transactions.add(withdrawAmount);
            this.balance += withdrawAmount;
            System.out.println(amount + " withdrawn. Balance now is : " + this.balance);
        }
        else {
            System.out.println("Cannot withdraw amount of: " + amount);
        }
    }

    public void calculateBalance() {
        int calculatedBalance = 0;
        for(int i: this.transactions) {
            calculatedBalance += i;
        }
        System.out.println("Calculated balance is: " + calculatedBalance + " vs stored balance: " + this.balance);
    }
}
