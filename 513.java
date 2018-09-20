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
	int maxLevel = -1, leftmost;
	public int findBottomLeftValue(TreeNode root) {
		findBottomLeftValueUtil(root, 0);
		return leftmost;
	}
	private void findBottomLeftValueUtil(TreeNode root, int level) {
		findBottomLeftValueUtil(root.left, level + 1);
		if(level > maxLevel) {
			maxLevel = level;
			leftmost = root.val;
		}
		findBottomLeftValueUtil(root.right, level + 1);
	}
}
