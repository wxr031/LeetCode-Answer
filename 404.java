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
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeavesUtil(root, false);
	}
	public int sumOfLeftLeavesUtil(TreeNode root, boolean isLeft) {
		if(root == null) {
			return 0;
		}
		if(isLeft && root.left == null && root.right == null) {
			return root.val;
		}
		return sumOfLeftLeavesUtil(root.left, true)
			+ sumOfLeftLeavesUtil(root.right, false);
	}
}
