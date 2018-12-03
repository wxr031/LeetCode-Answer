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
	private int tilt;
	public int findTilt(TreeNode root) {
		tilt = 0;
		findTiltUtil(root);
		return tilt;
	}
	private int findTiltUtil(TreeNode root) {
		if(root == null) return 0;
		int leftSum = findTiltUtil(root.left);
		int rightSum = findTiltUtil(root.right);
		tilt += Math.abs(leftSum - rightSum);
		return leftSum + rightSum + root.val;
	}
}
