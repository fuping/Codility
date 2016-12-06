package com.codility.lesson;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class CyclicRotationTest {

    @Test
    public void testDefault() {
	final int[] input = { 3, 8, 9, 7, 6 };
	final int rotation = 3;
	final int[] expect = { 9, 7, 6, 3, 8 };

	int[] result = CyclicRotation.solution(input, rotation);

	assertTrue(Arrays.equals(expect, result));
    }

}
