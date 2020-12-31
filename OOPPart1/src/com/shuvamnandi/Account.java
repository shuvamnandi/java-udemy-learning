package com.shuvamnandi;

public class Account {
    private String accountNumber;
    private String customerName;
    private String customerEmail;
    private int customerPhoneNumber;
    private double accountBalance;

    public Account() {
        this("123", "Default Name", "Default Address", 123, 0.0);
        System.out.println("Empty constructor called");
    }

    public Account(String accountNumber, double accountBalance) {
        System.out.println("Constructor called with few parameters");
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public Account(String accountNumber, String customerName, String customerEmail, int customerPhoneNumber, double accountBalance) {
        System.out.println("Constructor called with all parameters");
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account Number " + this.accountNumber + " for customer: " + this.customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        this.accountBalance += amount;
        System.out.println("Deposited amount: " + amount + ". New balance is " + this.accountBalance);
    }

    public void withdraw(double amount) {
        if (this.accountBalance - amount >= 0 ) {
            this.accountBalance -= amount;
            System.out.println("Withdrew amount: " + amount + ". New balance is " + this.accountBalance);
        } else {
            System.out.println("Cannot withdraw amount: " + amount + " as funds in account is only: " + this.accountBalance);
        }
    }
}


