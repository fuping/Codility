package com.codility.lesson.time_complexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermMissingElemTest {

    @Test
    public void testDefault() {
	final int[] input = { 2, 3, 1, 5 };
	final int expect = 4;

	int result = PermMissingElem.solution(input);

	assertEquals(expect, result);
    }

}
