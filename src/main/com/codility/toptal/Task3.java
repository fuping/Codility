/**
 * For this one the description was straight forward, but the implementation
 * kicked my butt. "You have an infinite chessboard, and a knight. The knight
 * starts at [0, 0] and can move [like a knight moves, skipped for brevity].
 * Given two coordinates on the board, return the least amount of moves the
 * knight has to make to get to that position". I only had 50min when I started
 * on this one, but even that wasn't enough for me to get even close to a
 * solution. I tried like 10 different things that didn't work, deleted them,
 * started over, etc; and at the end I had pretty much nothing.
 */
package com.codility.toptal;

import java.util.LinkedList;
import java.util.Queue;

public class Task3 {

    private static final int BLANK = -1;
    private static int rowLen;
    private static int colLen;
    private static Queue<Coordinate> queue;

    public static void main(String[] args) {

	int[][] board = { { -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
		{ -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
		{ -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
		{ -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 } };

	rowLen = board.length;
	colLen = board[0].length;
	int hops = path(board, 0, 0, rowLen - 1, colLen - 1);
	System.out.println(hops + " Moves");
    }

    /**
     * BFS to find the minimum moves to reach the destination
     * 
     * @return return number of hops if solution is available else -1
     */
    public static int path(int[][] board, int startRow, int startCol, int endRow, int endCol) {
	queue = new LinkedList<Coordinate>();
	queue.add(new Coordinate(startRow, startCol));
	queue.add(null); // this acts a delimiter
	board[startRow][startCol] = 0;
	int hops = 0;

	while (!queue.isEmpty()) {
	    Coordinate popedItem = queue.poll();

	    if (popedItem == null) {
		hops++;
		queue.offer(null);
		// System.out.println("======");
		continue;
	    }

	    int r = popedItem.row;
	    int c = popedItem.col;

	    board[r][c] = hops;

	    // System.out.println(hops + " " + r + " " + c);

	    if (r == endRow && c == endCol) {
		printSol(board);
		return hops;
	    }

	    Coordinate[] points = validCoordinates(board, r, c);

	    for (Coordinate o : points) {
		if (o != null)
		    queue.add(o);
	    }
	}
	return -1;
    }

    private static boolean isValid(int[][] board, int row, int col) {
	if (row >= 0 && row < colLen && col >= 0 && col < rowLen && board[row][col] == BLANK)
	    return true;
	return false;
    }

    public static Coordinate[] validCoordinates(int[][] board, int row, int col) {
	Coordinate[] points = new Coordinate[8];

	if (isValid(board, row + 2, col + 1))
	    points[0] = new Coordinate(row + 2, col + 1);

	if (isValid(board, row + 1, col + 2))
	    points[1] = new Coordinate(row + 1, col + 2);

	if (isValid(board, row - 1, col + 2))
	    points[2] = new Coordinate(row - 1, col + 2);

	if (isValid(board, row - 2, col + 1))
	    points[3] = new Coordinate(row - 2, col + 1);

	if (isValid(board, row - 2, col - 1))
	    points[4] = new Coordinate(row - 2, col - 1);

	if (isValid(board, row - 1, col - 2))
	    points[5] = new Coordinate(row - 1, col - 2);

	if (isValid(board, row + 1, col - 2))
	    points[6] = new Coordinate(row + 1, col - 2);

	if (isValid(board, row + 2, col - 1))
	    points[7] = new Coordinate(row + 2, col - 1);

	return points;
    }

    private static void printSol(int[][] board) {
	for (int i = 0; i < colLen; i++) {
	    for (int j = 0; j < rowLen; j++) {
		System.out.print(board[i][j] + "   ");
	    }
	    System.out.println();
	}
    }

    static class Coordinate implements Comparable<Coordinate> {

	public int row;
	public int col;

	public Coordinate() {
	    row = 0;
	    col = 0;
	}

	public Coordinate(int row, int col) {
	    this.row = row;
	    this.col = col;

	}

	@Override
	public int compareTo(Coordinate that) {
	    return this.row - that.row - this.col - that.col;
	}
    }

}
