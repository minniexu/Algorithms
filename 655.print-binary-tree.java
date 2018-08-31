/*
 * [655] Print Binary Tree
 *
 * https://leetcode.com/problems/print-binary-tree/description/
 *
 * algorithms
 * Medium (48.91%)
 * Total Accepted:    11.7K
 * Total Submissions: 24K
 * Testcase Example:  '[1,2]'
 *
 * Print a binary tree in an m*n 2D string array following these rules: 
 * 
 * 
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle
 * of the first row it can be put. The column and the row where the root node
 * belongs will separate the rest space into two parts (left-bottom part and
 * right-bottom part). You should print the left subtree in the left-bottom
 * part and print the right subtree in the right-bottom part. The left-bottom
 * part and the right-bottom part should have the same size. Even if one
 * subtree is none while the other is not, you don't need to print anything for
 * the none subtree but still need to leave the space as large as that for the
 * other subtree. However, if two subtrees are none, then you don't need to
 * leave space for both of them. 
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ⁠    1
 * ⁠   /
 * ⁠  2
 * Output:
 * [["", "1", ""],
 * ⁠["2", "", ""]]
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ⁠    1
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \
 * ⁠    4
 * Output:
 * [["", "", "", "1", "", "", ""],
 * ⁠["", "2", "", "", "", "3", ""],
 * ⁠["", "", "4", "", "", "", ""]]
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * ⁠     1
 * ⁠    / \
 * ⁠   2   5
 * ⁠  / 
 * ⁠ 3 
 * ⁠/ 
 * 4 
 * Output:
 * 
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ⁠["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ⁠["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ⁠["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 
 * 
 * 
 * Note:
 * The height of binary tree is in the range of [1, 10].
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
	List<List<String>> res = new ArrayList<>();
	int depth = root == null ? 1 : depthHelper(root);
	int size = (int) Math.pow(2, depth) - 1;
	for (int i = 0; i < depth; i++) {
		res.add(new ArrayList<>());
		for (int j = 0; j < size; j++) {
			res.get(i).add("");
		}
	}
	helperAddEmpty(res, root, 0, size - 1, 0);
	return res;
    }

    private void helperAddEmpty(List<List<String>> res, TreeNode root, int i, int j, int row) {
	if (row >= res.size() || root == null) return;
	res.get(row).set((i + j) / 2, String.valueOf(root.val));
	helperAddEmpty(res, root.left, i, (i + j) / 2 - 1, row + 1);
	helperAddEmpty(res, root.right, (i + j) / 2 + 1, j, row + 1);    	
    }
    private int depthHelper(TreeNode root) {
	if (root == null) return 0;
	return 1 + Math.max(depthHelper(root.left), depthHelper(root.right));
    }
}

