/**
 * Your function takes an array of integers (arr), and an integer (x). You need
 * to find the position in arr that splits the array in two, where one side has
 * as many occurrences of x as the other side has occurrences of any number but
 * x (there was some additional info about edge cases, but that's the gist of
 * it). So, given an array like this: [5, 5, 2, 3, 5, 1, 6] and x being "5", the
 * function should return "4" (Position 4, holding the number "3" above is the
 * point where you have 2 5's on the one side, and two "not fives" on the other.
 */
package com.codility.toptal;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static int solution(int[] arr, int x) {
	// null check and length check
	if (arr == null || arr.length < 3) {
	    return -1;
	}

	// build a list with indexes of x in array arr
	List<Integer> indexes = new ArrayList<>();

	// loop through the array to build the index list
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == x) {
		indexes.add(i);
	    }
	}

	// odd numbers of common value
	if (indexes.size() % 2 != 0) {
	    return -1;
	}

	// find out balance point
	int middle = indexes.size() / 2;

	// left and right range to split the array
	int indexAfter = indexes.get(middle);
	int indexBefore = indexes.get(middle - 1);

	// 2 common value's indexes are next to each other
	if (indexAfter - indexBefore < 2) {
	    return -1;
	} else {
	    return indexBefore + 1;
	}
    }

}
