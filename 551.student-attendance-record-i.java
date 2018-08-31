/*
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (44.93%)
 * Total Accepted:    38.5K
 * Total Submissions: 85.8K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean checkRecord(String s) {
	int absent = 0, late = 0;
	for (int i = 0; i < s.length(); i++) {
		int k = i;
		while (i < s.length() && s.charAt(i) == 'L') {
			i++;
		}
		late = Math.max(late, i - k);
		
		if (i < s.length() && s.charAt(i) == 'A') {
			absent++;
		}
	}        
	return !(absent > 1 || late > 2);
    }
}
