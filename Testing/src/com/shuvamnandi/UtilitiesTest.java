package com.shuvamnandi;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    Utilities utilities;

    @BeforeEach
    void setUp() {
        utilities = new Utilities();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown() called");
    }

    @Test
    void everyNthChar() {
        fail("Not implemented");
    }

    @Test
    void removePairs() {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCBDEF", utilities.removePairs("AABCCBDDEFF"));
    }

    @Test
    void convertor() {
        fail("Not implemented");
    }

    @Test
    void nullIfOddLength() {
        fail("Not implemented");
    }
}