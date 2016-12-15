/**
 * A small frog wants to get to the other side of the road. The frog is
 * currently located at position X and wants to get to a position greater than
 * or equal to Y. The small frog always jumps a fixed distance, D.
 * 
 * Count the minimal number of jumps that the small frog must perform to reach
 * its target.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int X, int Y, int D); } that, given
 * three integers X, Y and D, returns the minimal number of jumps from position
 * X to a position equal to or greater than Y.
 * 
 * For example, given:
 * 
 * X = 10<br>
 * Y = 85<br>
 * D = 30<br>
 * the function should return 3, because the frog will be positioned as follows:
 * 
 * after the first jump, at position 10 + 30 = 40<br>
 * after the second jump, at position 10 + 30 + 30 = 70<br>
 * after the third jump, at position 10 + 30 + 30 + 30 = 100<br>
 * 
 * Assume that:
 * 
 * X, Y and D are integers within the range [1..1,000,000,000]; X ¡Ü Y.
 * 
 * Complexity:
 * 
 * expected worst-case time complexity is O(1); <br>
 * expected worst-case space complexity is O(1).
 */
package com.codility.lesson.time_complexity;

public class FrogJmp {

    /**
     * Straight forward solution
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance 100% <br>
     * 
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public static int solution(int X, int Y, int D) {

	// (Y - X) / D
	// (Y - X) % D != 0 ?

	if ((Y - X) % D != 0) {
	    return ((Y - X) / D) + 1;
	}

	return (Y - X) / D;
    }

    /**
     * Math ceil function to get the smallest (closest to negative infinity)
     * double value that is greater than or equal to the argument and is equal
     * to a mathematical integer.
     * 
     * Assessment: <br>
     * Correctness 100% <br>
     * Performance 100% <br>
     * 
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public static int solution0(int X, int Y, int D) {

	return (int) Math.ceil((Y - X) / (double) D);
    }

}
