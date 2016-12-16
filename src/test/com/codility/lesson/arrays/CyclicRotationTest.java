package com.codility.lesson.arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CyclicRotationTest {

    @Test
    public void testDefault() {
	final int[] input = { 3, 8, 9, 7, 6 };
	final int rotation = 3;
	final int[] expect = { 9, 7, 6, 3, 8 };

	int[] result = CyclicRotation.solution(input, rotation);

	assertArrayEquals(expect, result);

	assertArrayEquals(input, CyclicRotation.solution(input, 0));
	assertArrayEquals(new int[] { 6, 3, 8, 9, 7 }, CyclicRotation.solution(input, 1));
	assertArrayEquals(new int[] { 7, 6, 3, 8, 9 }, CyclicRotation.solution(input, 2));
	assertArrayEquals(new int[] { 9, 7, 6, 3, 8 }, CyclicRotation.solution(input, 3));

	assertArrayEquals(input, CyclicRotation.solution(input, 5));
	assertArrayEquals(new int[] { 6, 3, 8, 9, 7 }, CyclicRotation.solution(input, 6));
	assertArrayEquals(new int[] { 7, 6, 3, 8, 9 }, CyclicRotation.solution(input, 7));
	assertArrayEquals(new int[] { 9, 7, 6, 3, 8 }, CyclicRotation.solution(input, 8));

	assertArrayEquals(input, CyclicRotation.solution(input, 10));
	assertArrayEquals(new int[] { 6, 3, 8, 9, 7 }, CyclicRotation.solution(input, 11));
	assertArrayEquals(new int[] { 7, 6, 3, 8, 9 }, CyclicRotation.solution(input, 12));
	assertArrayEquals(new int[] { 9, 7, 6, 3, 8 }, CyclicRotation.solution(input, 13));
    }

}
