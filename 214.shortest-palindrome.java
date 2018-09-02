/*
 * [214] Shortest Palindrome
 *
 * https://leetcode.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (25.77%)
 * Total Accepted:    59.4K
 * Total Submissions: 230.3K
 * Testcase Example:  '"aacecaaa"'
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * 
 * 
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcd"
 * Output: "dcbabcd"
 * 
 */
class Solution {
    public String shortestPalindrome(String s) {
	if (s.length() <= 1) return s;
	int n = (s.length() - 1) / 2;
	for (int i = n; i >= 0; i--) {
		if (s.charAt(i) == s.charAt(i + 1)) {
			String cur = check(s, i, i + 1);
			if (cur != null) return cur; 
		} 
		String cur = check(s, i, i);
		if (cur != null) return cur;
	}        
	return null;
    }
    private String check(String s, int left, int right) {
	int i = 1;
	for (; left - i >= 0 && right + i < s.length(); i++) {
		if (s.charAt(left - i) != s.charAt(right + i)) break;
	}
	if (left - i >= 0) return null;
	StringBuilder sb = new StringBuilder(s.substring(right + i));
	return sb.reverse().append(s).toString();
    }
}
