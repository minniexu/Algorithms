/*
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (47.20%)
 * Total Accepted:    60.7K
 * Total Submissions: 128.7K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * 
 * 
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * 
 * 
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 * 
 */
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
	if (map.containsKey(input)) {
	    return map.get(input);
	}
	List<Integer> list = new ArrayList<>();
	for (int i = 0; i < input.length(); i++) {
	    char c = input.charAt(i);
	    if (c == '+' || c == '-' || c == '*') {
		List<Integer> pre = diffWaysToCompute(input.substring(0, i));
		List<Integer> post = diffWaysToCompute(input.substring(i + 1));
		for (int p1 : pre) {
		    for (int p2 : post) {
			if (c == '+') {
			    list.add(p1 + p2);
			} else if (c == '-') {
			    list.add(p1 - p2);
			} else if (c == '*') {
			    list.add(p1 * p2);
			}
		    }
		}	
	    }
	}        
	if (list.size() == 0) {
	    list.add(Integer.parseInt(input));
	}
	map.put(input, list);
	return list;
    }
}
