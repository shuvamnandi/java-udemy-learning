package com.shuvamnandi;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    private static int count;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("It executes before all test cases. Count: " + count++);
    }

    @BeforeEach
    public void setUp() {
        // A new bank account is being instantiated before each time runs
        account = new Account("Shuvam", "Nandi", 1000.00, Account.SAVINGS);
        System.out.println("Running a test");
    }

    @Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, account.getBalance());
    }

    @Test
    public void withdraw_legal() {
        account.withdraw(600.00, true);
        assertEquals(400.00, account.getBalance());
        assertEquals(400.00, account.getBalance());
    }

    @Test
    public void withdraw_illegal() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600, false));
        assertEquals(1000.00, account.getBalance());
        assertEquals(1000.00, account.getBalance());
    }

    @Test
    public void withdraw_illegal_old_junit() {
        try {
            account.withdraw(600, false);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e ) {
            System.out.println("Exception was caught, test is passed");
        }
    }

    @Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance());
    }

    @Test
    public void getBalance_withdraw() {
        account.withdraw(100.00, true);
        assertEquals(900.00, account.getBalance());
    }

    @Test
    public void isChecking_false() {
        assertFalse(account.isChecking());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Count = " + count++);
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("It executes after all test cases. Count: " + count++);
    }
}