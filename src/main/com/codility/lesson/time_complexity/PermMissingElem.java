/**
 * A zero-indexed array A consisting of N different integers is given. The array
 * contains integers in the range [1..(N + 1)], which means that exactly one
 * element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:<br>
 * class Solution { public int solution(int[] A); } that, given a zero-indexed
 * array A, returns the value of the missing element.
 * 
 * For example, given array A such that:<br>
 * A[0] = 2<br>
 * A[1] = 3<br>
 * A[2] = 1<br>
 * A[3] = 5<br>
 * the function should return 4, as it is the missing element.
 * 
 * Assume that:<br>
 * N is an integer within the range [0..100,000];<br>
 * the elements of A are all distinct;<br>
 * each element of array A is an integer within the range [1..(N + 1)].
 * 
 * Complexity: <br>
 * expected worst-case time complexity is O(N);<br>
 * expected worst-case space complexity is O(1), beyond input storage (not
 * counting the storage required for input arguments).
 * 
 * Elements of input arrays can be modified.
 */
package com.codility.lesson.time_complexity;

import java.util.stream.IntStream;

public class PermMissingElem {

    /**
     * Loop through all elements of the array and compare the sum
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance 100% <br>
     * 
     * @param A
     * @return
     */
    public static int solution0(int[] A) {
	// null and size check
	if (A == null || A.length > 1000000) {
	    throw new IllegalArgumentException();
	}

	// empty array
	if (A.length < 1) {
	    return 1;
	}

	// create the sum
	int sum = A.length + A.length + 1;

	// loop through all elements
	for (int i = 0; i < A.length; i++) {
	    sum = sum + i - A[i];
	}

	return sum;
    }

    /**
     * By knowing 1+ 2+ ... + n = n(n+1) / 2, for n a natural number, then no
     * loop required
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance 60% <br>
     * large_range: got -2147483647 expected 1; got -2147471303 expected 12345
     * <br>
     * large2: got -2147473647 expected 10001
     * 
     * @param A
     * @return
     */
    public static int solution(int[] A) {
	// null and size check
	if (A == null || A.length > 1000000) {
	    throw new IllegalArgumentException();
	}

	// empty array
	if (A.length < 1) {
	    return 1;
	}

	// create the sum
	int sum = (1 + A.length + 1) * (A.length + 1) / 2;

	return sum - IntStream.of(A).sum();
    }

}
