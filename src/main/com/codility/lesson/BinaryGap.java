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
 */
package com.codility.lesson;

public class BinaryGap {

    /**
     * Straight forward solution which has bad performance <br>
     * Test score 100 out of 100 points
     * 
     * @param N
     * @return
     */
    public static int calculateBinaryGap(int N) {
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

}
