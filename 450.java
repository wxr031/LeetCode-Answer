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
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		}
		else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		}
		else {
			if (root.left == null && root.right == null) {
				return null;
			}
			else if (root.left == null) {
				return root.right;
			}
			else if (root.right == null) {
				return root.left;
			}
			else {
				TreeNode leftMost = root.right;
				while (leftMost.left != null) {
					leftMost = leftMost.left;
				}
				root.val = leftMost.val;
				root.right = deleteNode(root.right, root.val);
			}
		}
		return root;
	}
}
