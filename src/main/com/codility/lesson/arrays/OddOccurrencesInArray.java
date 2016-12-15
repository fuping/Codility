/**
 * A non-empty zero-indexed array A consisting of N integers is given. The array
 * contains an odd number of elements, and each element of the array can be
 * paired with another element that has the same value, except for one element
 * that is left unpaired.
 * 
 * For example, in array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
 * value 7 and is unpaired.
 * 
 * Write a function: class Solution { public int solution(int[] A); } that,
 * given an array A consisting of N integers fulfilling the above conditions,
 * returns the value of the unpaired element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the function
 * should return 7, as explained in the example above.
 * 
 * Assume that:
 * 
 * N is an odd integer within the range [1..1,000,000]; each element of array A
 * is an integer within the range [1..1,000,000,000]; all but one of the values
 * in A occur an even number of times. Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 */
package com.codility.lesson.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Odd occurrences
 * 
 * @author FupingM
 */
public class OddOccurrencesInArray {

    /**
     * hash map solution
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance 100% <br>
     * 
     * Detected time complexity: O(N) or O(N*log(N))
     * 
     * @param A
     * @return
     */
    public static int solution0(int[] A) {
	// null check
	if (A == null || A.length < 1) {
	    throw new IllegalArgumentException("Invalid input int array.");
	}

	// create a map to hold processed data
	Map<Integer, Integer> oddMap = new HashMap<Integer, Integer>();

	// loop through the array
	for (int x : A) {
	    // remove the element if it occurred before
	    if (oddMap.containsKey(x)) {
		oddMap.remove(x);
	    }
	    // keep the element if it occurred even times
	    else {
		oddMap.put(x, 1);
	    }
	}

	// the map should contain the only element which occurs even times
	return (int) oddMap.keySet().toArray()[0];
    }

    /**
     * XOR solution
     * 
     * 1) XOR of any number n with itself gives us 0, i.e., n ^ n = 0<br>
     * 2) XOR of any number n with 0 gives us n, i.e., n ^ 0 = n<br>
     * 3) XOR is cumulative and associative.
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance 75% (failed on n = 2,001 which runs 0.684s and the limit is
     * 0.51s) <br>
     * 
     * Detected time complexity: O(N) or O(N*log(N))<br>
     * (The performance is better only for large array which n = 999,999)
     * 
     * @param A
     * @return
     */
    public static int solution(int[] A) {
	// null check
	if (A == null || A.length < 1) {
	    throw new IllegalArgumentException("Invalid input int array.");
	}

	return Arrays.stream(A).reduce(0, (x, y) -> x ^ y);
    }

}
