/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the
 * array means that each element is shifted right by one index, and the last
 * element of the array is also moved to the first place.
 * 
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right by K indexes.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); } that, given a
 * zero-indexed array A consisting of N integers and an integer K, returns the
 * array A rotated K times.
 * 
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should
 * return [9, 7, 6, 3, 8].
 * 
 * Assume that:
 * 
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [-1,000..1,000].
 */
package com.codility.lesson.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Array Rotation
 * 
 * @author FupingM
 */
public class CyclicRotation {

    /**
     * Use linked list structure to rotate the array
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance not assessed <br>
     * 
     * @param A
     * @param K
     * @return
     */
    public static int[] solution(int[] A, int K) {
	// null check
	if (A != null && A.length < 2) {
	    return A;
	}

	// K%N, if K is greater than N, than only rotate the array K%N times
	K = K % A.length;
	if (K == 0) {
	    return A;
	}

	// convert array to linked list
	LinkedList<Integer> AList = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));

	// rotate linked list
	for (int i = 0; i < K; i++) {
	    AList.addFirst(AList.getLast());
	    AList.removeLast();
	}

	// convert linked list back to array
	return AList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * split and join solution, no loop
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance not assessed <br>
     * 
     * @param A
     * @param K
     * @return
     */
    public static int[] solution1(int[] A, int K) {
	// null check
	if (A != null && A.length < 2) {
	    return A;
	}

	// K%N, if K is greater than N, than only rotate the array K%N times
	K = K % A.length;
	if (K == 0) {
	    return A;
	}

	// split the array at A.length - K as left and right
	int[] left = Arrays.copyOfRange(A, 0, A.length - K);
	int[] right = Arrays.copyOfRange(A, A.length - K, A.length);

	// join the array as right + left
	return IntStream.concat(Arrays.stream(right), Arrays.stream(left)).toArray();
    }

    /**
     * create a new array based on array A and factor K logic (best performance
     * so far...)
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance not assessed <br>
     * 
     * @param A
     * @param K
     * @return
     */
    public static int[] solution2(int[] A, int K) {
	// null check
	if (A != null && A.length < 2) {
	    return A;
	}

	// new empty array as the same length as A
	int[] B = new int[A.length];

	// loop through array A
	for (int i = 0; i < A.length; i++) {
	    // fill array B with K logic
	    B[(i + K) % A.length] = A[i];
	}

	return B;
    }

}
