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
        assertArrayEquals("el".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 2));
        assertArrayEquals("l r".toCharArray(), utilities.everyNthChar("hello world".toCharArray(), 3));
        assertArrayEquals("hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 8));
    }

    @Test
    void removePairs() {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCBDEF", utilities.removePairs("AABCCCBDDDDEFF"));
        assertEquals("", utilities.removePairs(""));
        assertEquals("A", utilities.removePairs("AA"));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("AB", utilities.removePairs("AB"));
        assertNull(utilities.removePairs(null), "Did not get null returned" );
    }

    @Test
    void convertor() {
        assertEquals(300, utilities.convertor(10, 5));
    }

    @Test
    void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("hello"));
        assertEquals("hello ", utilities.nullIfOddLength("hello "));
    }
}