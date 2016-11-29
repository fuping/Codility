package com.codility.lesson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryGapTest {

    @Test
    public void test9() {
	int input = 9;
	int expect = 2;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    public void test529() {
	int input = 529;
	int expect = 4;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    public void test20() {
	int input = 20;
	int expect = 1;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    public void test15() {
	int input = 15;
	int expect = 0;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    public void test1041() {
	int input = 1041;
	int expect = 5;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    // trailing_zeroes
    public void test328() {
	int input = 328; // 101001000
	int expect = 2;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    public void test1162() {
	int input = 1162; // 10010001010
	int expect = 3;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    // medium1
    public void test51712() {
	int input = 51712; // 110010100000000
	int expect = 2;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    // medium3
    public void test66561() {
	int input = 66561; // 10000010000000001
	int expect = 9;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    // large1
    public void test6291457() {
	int input = 6291457; // 11000000000000000000001
	int expect = 20;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    // large3
    public void test805306373() {
	int input = 805306373; // 110000000000000000000000000101
	int expect = 25;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }

    @Test
    // large6
    public void test1610612737() {
	int input = 1610612737; // 1100000000000000000000000000001
	int expect = 28;

	int result = BinaryGap.calculateBinaryGap(input);

	assertEquals(expect, result);
    }
}
