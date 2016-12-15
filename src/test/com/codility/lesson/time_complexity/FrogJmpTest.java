package com.codility.lesson.time_complexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrogJmpTest {

    @Test
    public void testDefault() {
	final int inputX = 10;
	final int inputY = 85;
	final int inputD = 30;
	final int expect = 3;

	int result = FrogJmp.solution0(inputX, inputY, inputD);

	assertEquals(expect, result);
    }
}
