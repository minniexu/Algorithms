/*
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (25.56%)
 * Total Accepted:    87.6K
 * Total Submissions: 342.5K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 * 
 * 
 */
class Solution {
    public int minCut(String s) {
	int n = s.length();
	boolean[][] dp = new boolean[n][n];
	int[] minCut = new int[n];
	for (int j = 0; j < n; j++) {
		int min = j;
		for (int i = 0; i <= j; i++) {
			if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1])) {
				dp[i][j] = true;
				min = i == 0 ? 0 : Math.min(minCut[i - 1] + 1, min);	
			}
		}
		minCut[j] = min;
	}        
	return minCut[n - 1];
    }
}
