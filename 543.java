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
	TreeNode been = new TreeNode(0);
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0; 
		return Math.max(diameterOfBinaryTree(root.left), Math.max(diameterOfBinaryTree(root.right),
					depth(root.left) + depth(root.right)));
	}
	private int depth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == been) return root.val;
		root.val = Math.max(depth(root.left), depth(root.right)) + 1;
		root.left = been;
		return root.val;
	}
}
