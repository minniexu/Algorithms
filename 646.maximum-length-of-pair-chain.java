/*
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (47.45%)
 * Total Accepted:    25.2K
 * Total Submissions: 53K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
	Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
	int[] total = new int[pairs.length];
	Arrays.fill(total, 1);
	for (int i = 0; i < total.length; i++) {
		for (int j = i - 1; j >= 0; j--) {
			//total[i] = Math.max(pairs[i][0] > pairs[j][1] ? total[j] + 1 : total[j], total[i]);
			if (pairs[i][0] > pairs[j][1]) {
				total[i] = total[j] + 1;
				break;
			}
		}
	}
	return total[pairs.length - 1];
    }
}
