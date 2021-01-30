package com.shuvamnandi;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;

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

    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"A", "A"},
        });
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    public void removePairs(String input, String expected) {
        assertEquals(expected, utilities.removePairs(input));
    }

    @Test
    public void convertor_pass() {
        assertEquals(300, utilities.convertor(10, 5));
    }

    @Test
    public void convertor_throws() {
        assertThrows(ArithmeticException.class, () -> utilities.convertor(10, 0));
    }

    @Test
    public void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("hello"));
        assertEquals("hello ", utilities.nullIfOddLength("hello "));
    }
}