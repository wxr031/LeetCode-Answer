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
	public boolean isBalanced(TreeNode root) {
		return (isBalancedUtil(root) == -1) ? false : true;
	}
	public int isBalancedUtil(TreeNode root) {
		if(root == null) return 0;
		int leftHeight = isBalancedUtil(root.left);
		int rightHeight = isBalancedUtil(root.right);
		if(leftHeight == -1 || rightHeight == -1) {
			return -1;
		}
		if(leftHeight == rightHeight || leftHeight == rightHeight + 1) {
			return leftHeight + 1;
		}
		if(rightHeight == leftHeight + 1) {
			return rightHeight + 1;
		}
		return -1;
	}
}

