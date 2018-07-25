/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		return pathSum(root.left, sum) + pathSumUtil(root, sum) + pathSum(root.right, sum);
	}
	private int pathSumUtil(TreeNode root, int sum) {
		if (root == null) return 0;
		return pathSumUtil(root.left, sum - root.val) 
			+ (root.val == sum ? 1 : 0)
			+ pathSumUtil(root.right, sum - root.val);
	}
}
