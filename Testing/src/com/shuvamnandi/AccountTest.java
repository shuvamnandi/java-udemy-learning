package com.shuvamnandi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void deposit() {
        Account account = new Account("Shuvam", "Nandi", 1000.00, Account.SAVINGS);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, account.getBalance());
    }

    @Test
    void withdraw() {
        Account account = new Account("Shuvam", "Nandi", 1000.00, Account.SAVINGS);
        account.withdraw(100.00, true);
        assertEquals(900.00, account.getBalance());
        assertEquals(900.00, account.getBalance());
    }

    @Test
    void getBalance_deposit() {
        Account account = new Account("Shuvam", "Nandi", 1000.00, Account.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance());
    }

    @Test
    void getBalance_withdraw() {
        Account account = new Account("Shuvam", "Nandi", 1000.00, Account.CHECKING);
        account.withdraw(100.00, true);
        assertEquals(900.00, account.getBalance());
    }

    @Test
    void isChecking_true() {
        Account account = new Account("Shuvam", "Nandi", 1000.00, Account.CHECKING);
        assertTrue(account.isChecking());
    }

    @Test
    void isChecking_false() {
        Account account = new Account("Shuvam", "Nandi", 1000.00, Account.SAVINGS);
        assertFalse(account.isChecking());
    }

}