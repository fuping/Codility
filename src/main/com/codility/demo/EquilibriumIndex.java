/**
 * A zero-indexed array A consisting of N integers is given. An equilibrium
 * index of this array is any integer P such that 0 ≤ P < N and the sum of
 * elements of lower indices is equal to the sum of elements of higher indices,
 * i.e. <br>
 * A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].<br>
 * Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or
 * if P = N−1.<br>
 * 
 * For example, consider the following array A consisting of N = 8 elements:<br>
 * A[0] = -1<br>
 * A[1] = 3<br>
 * A[2] = -4<br>
 * A[3] = 5<br>
 * A[4] = 1<br>
 * A[5] = -6<br>
 * A[6] = 2<br>
 * A[7] = 1<br>
 * 
 * P = 1 is an equilibrium index of this array, because:<br>
 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]<br>
 * 
 * P = 3 is an equilibrium index of this array, because:<br>
 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]<br>
 * 
 * P = 7 is also an equilibrium index, because:<br>
 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0<br>
 * 
 * and there are no elements with indices greater than 7.<br>
 * P = 8 is not an equilibrium index, because it does not fulfill the condition
 * 0 ≤ P < N.
 */

package com.codility.demo;

import java.util.Arrays;

public class EquilibriumIndex {

    /**
     * given a zero-indexed array A consisting of N integers, returns any of its
     * equilibrium indices. The function should return −1 if no equilibrium
     * index exists.
     * 
     * @param A
     * @return
     */
    public static int findEquilibriumIndex(int[] A) {
	// empty check
	if (A == null || A.length < 1) {
	    return -1;
	}

	// sum of int array
	long total = Arrays.stream(A).sum();

	// left side starts with 0
	long left = 0;
	for (int i = 0; i < A.length; i++) {
	    // finding equilibrium point
	    if (left == total - left - A[i]) {
		return i;
	    }

	    // sum up left
	    left = left + A[i];
	}

	return -1;
    }

}
