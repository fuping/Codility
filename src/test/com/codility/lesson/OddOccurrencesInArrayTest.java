package com.codility.lesson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddOccurrencesInArrayTest {

    @Test
    public void testDefault() {
	final int[] input = { 9, 3, 9, 3, 9, 7, 9 };
	final int expect = 7;

	int result = OddOccurrencesInArray.solution(input);

	assertEquals(expect, result);
    }
}
