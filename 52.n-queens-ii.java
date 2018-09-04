/*
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (48.34%)
 * Total Accepted:    81.9K
 * Total Submissions: 169.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    public int totalNQueens(int n) {
	int[] nums = new int[1];
	placeQueens(0, new int[n], nums, n);
	return nums[0];
    }
    private void placeQueens(int row, int[] cols, int[] nums, int n) {
    	if (row == n) {
	    nums[0]++;
	} else {
	    for (int col = 0; col < n; col++) {
	        if (checkValid(cols, row, col)) {
		    cols[row] = col;
 		    placeQueens(row + 1, cols, nums, n);
		}
	    }	
	}
    }
    private boolean checkValid(int[] cols, int row, int col) {
	for (int i = 0; i < row; i++) {
	    int colNum = cols[i];
	    if (colNum == col) {
	        return false;
	    }
	    int disCol = Math.abs(colNum - col);
	    int disRow = Math.abs(row - i);
	    if (disCol == disRow) {
		return false;
	    }	    
	}
	return true;	
    }
}
