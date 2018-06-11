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
	public boolean isValidBST(TreeNode root) {
		return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	private boolean isValidBSTUtil(TreeNode root, long narrowLeft, long narrowRight) {
		if(root == null) return true;
		if(root.val >= narrowRight || root.val <= narrowLeft) return false;
		return isValidBSTUtil(root.left, narrowLeft, (long)root.val) 
			&& isValidBSTUtil(root.right, (long)root.val, narrowRight);
	}
}
