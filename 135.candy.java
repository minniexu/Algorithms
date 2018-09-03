/*
 * [135] Candy
 *
 * https://leetcode.com/problems/candy/description/
 *
 * algorithms
 * Hard (25.97%)
 * Total Accepted:    83.6K
 * Total Submissions: 321.9K
 * Testcase Example:  '[1,0,2]'
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * 
 * 
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2,
 * 1, 2 candies respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1,
 * 2, 1 candies respectively.
 * ⁠            The third child gets 1 candy because it satisfies the above two
 * conditions.
 * 
 * 
 */
class Solution {
    public int candy(int[] ratings) {
	int[] res = new int[ratings.length];
	Arrays.fill(res, 1);
	for (int i = 1; i < ratings.length; i++) {
		if (ratings[i] > ratings[i - 1]) {
			res[i] = res[i - 1] + 1;
		}
	}        
	for (int i = ratings.length - 1; i >= 1; i--) {
		if (ratings[i - 1] > ratings[i]) {
			res[i - 1] = Math.max(res[i - 1], res[i] + 1);
		}
	}
	int sum = 0;
	for (int i : res) {
		sum += i;
	}
	return sum;
    }
}
