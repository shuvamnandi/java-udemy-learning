package com.shuvamnandi;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    Utilities utilities;

    @BeforeEach
    public void setUp() {
        utilities = new Utilities();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown() called");
    }

    @Test
    public void everyNthChar() {
        assertArrayEquals("el".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 2));
        assertArrayEquals("l r".toCharArray(), utilities.everyNthChar("hello world".toCharArray(), 3));
        assertArrayEquals("hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 8));
    }

    @Test
    public void removePairs() {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCBDEF", utilities.removePairs("AABCCCBDDDDEFF"));
        assertEquals("", utilities.removePairs(""));
        assertEquals("A", utilities.removePairs("AA"));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("AB", utilities.removePairs("AB"));
        assertNull(utilities.removePairs(null), "Did not get null returned" );
    }

    @Test
    public void convertor_pass() {
        assertEquals(300, utilities.convertor(10, 5));
    }

    @Test
    public void convertor_throws() {
        assertThrows(ArithmeticException.class, () -> utilities.convertor(10, 10));
    }

    @Test
    public void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("hello"));
        assertEquals("hello ", utilities.nullIfOddLength("hello "));
    }
}