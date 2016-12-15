/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps.
 * 
 * Assume that: N is an integer within the range [1..2,147,483,647].
 * 
 * Complexity: expected worst-case time complexity is O(log(N)); expected
 * worst-case space complexity is O(1).
 */
package com.codility.lesson.iterations;

import java.util.stream.Stream;

/**
 * Find longest sequence of zeros in binary representation of an integer.
 * 
 * @author Fuping
 */
public class BinaryGap {

    /**
     * Straight forward solution which has bad performance <br>
     * Test score 100 out of 100 points
     * 
     * @param N
     * @return
     */
    public static int calculateBinaryGap0(int N) {
	// positive number check
	if (N <= 0) {
	    return 0;
	}

	// initial binary gap as viable default to 0
	int binaryGap = 0;

	// get binary string from the given integer
	String binaryString = Integer.toBinaryString(N);

	// print input in the console
	// System.out.println("Input integer: " + N);
	// System.out.println("Binary String: " + binaryString);

	// create a counter
	int counter = -1;
	// loop through the binary string
	for (int i = 0; i < binaryString.length(); i++) {
	    // 0
	    if (binaryString.charAt(i) == Character.forDigit(0, 10)) {
		// increase the counter only if counting has started
		if (counter >= 0) {
		    counter++;
		} else {
		    continue;
		}
	    }
	    // 1
	    else {
		// start counting
		if (counter < 0) {
		    counter = 0;
		}
		// finish counting
		else {
		    // keep the larger number
		    binaryGap = Math.max(binaryGap, counter);
		    // reset counter/restart counting
		    counter = 0;
		}
	    }
	}

	return binaryGap;
    }

    /**
     * Processing Data with Java SE 8 Streams
     * 
     * @param N
     * @return
     */
    public static int calculateBinaryGap(int N) {
	return Stream
		.of(
			// integer to binary string
			Integer.toBinaryString(N)
				// remove the potential 0(s) at the end of the
				// string (0 to unlimited 0s and end with 0)
				.replaceAll("0+$", "")
				// split string to array by integer '1' which
				// array elements contains 0s only
				.split("1+"))
		// lambda expressions: use filter to keep not null elements
		.filter(a -> a != null)
		// method references: convert stream to integer by using the
		// length of string elements
		.map(String::length)
		// method references: find the largest number in the stream by
		// using integer comparator
		.max(Integer::compare)
		// return 0 if nothing matches the operations above
		.orElse(0);

    }

}
