package com.codility.lesson.time_complexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TapeEquilibriumTest {

    @Test
    public void testDefault() {
	final int[] input = { 3, 1, 2, 4, 3 };
	final int expect = 1;

	int result = TapeEquilibrium.solution(input);

	assertEquals(expect, result);
    }

    @Test
    public void testDouble() {
	final int[] input = { 1000, -1000 };
	final int expect = 2000;

	int result = TapeEquilibrium.solution(input);

	assertEquals(expect, result);
    }

}
