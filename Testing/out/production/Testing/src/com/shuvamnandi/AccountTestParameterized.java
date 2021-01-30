package com.shuvamnandi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTestParameterized {
    private Account account;

    @BeforeEach
    public void setup() {
        account = new Account("Shuvam", "Nandi", 1000.00, Account.SAVINGS);
    }

    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
        });
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    public void deposit(double amount, boolean branch, double expected) {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
