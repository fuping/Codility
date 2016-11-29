package com.codility.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EquilibriumIndexTest {

    @Test
    public void testDefault() {

	int[] A = { -1, 3, -4, 5, 1, -6, 2, 1 };

	int index = EquilibriumIndex.findEquilibriumIndex(A);

	System.out.println("index: " + index);

	assertTrue(index == 1 || index == 3 || index == 7);
    }

}
