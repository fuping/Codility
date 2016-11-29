package com.codility.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EquilibriumIndexTest {

    @Test
    public void testDefault() {

	int[] A = { -1, 3, -4, 5, 1, -6, 2, 1 };

	int index = EquilibriumIndex.findEquilibriumIndex(A);

	assertTrue(index == 1 || index == 3 || index == 7);
    }

    @Test
    // Sequence with extremely large numbers testing arithmetic overflow
    public void testExtremelyLargeNumbers() {

	int[] A = { 1082132608, 0, 1082132608 };

	int index = EquilibriumIndex.findEquilibriumIndex(A);

	assertEquals(1, index);
    }

    @Test
    // Sequence with extremely negative numbers testing arithmetic overflow
    public void testExtremelyNegativeNumbers() {

	int[] A = { 0, -1000000000, -1000000000, -1000000000, -1000000000, -294967296 };

	int index = EquilibriumIndex.findEquilibriumIndex(A);

	assertEquals(-1, index);
    }

    @Test
    // arithmetic overflow tests
    public void testOverflow1() {

	int[] A = { 2147483647, 2147483647, 2147483647 };

	int index = EquilibriumIndex.findEquilibriumIndex(A);

	assertEquals(1, index);
    }

    @Test
    // arithmetic overflow tests
    public void testOverflow2() {

	int[] A = { 0, 2147483647, 2147483647, 2147483647 };

	int index = EquilibriumIndex.findEquilibriumIndex(A);

	assertEquals(1, index);
    }
}
