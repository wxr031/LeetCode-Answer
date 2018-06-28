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
	TreeNode change1 = null, change2 = null;
	TreeNode prevNode = null;
	public void recoverTree(TreeNode root) {
		recoverTreeUtil(root);

		int temp = change1.val;
		change1.val = change2.val;
		change2.val = temp;
	}
	private void recoverTreeUtil(TreeNode root) {
		if(root == null) return;
		recoverTreeUtil(root.left);
		if(change1 == null && prevNode != null && prevNode.val > root.val) {
			change1 = prevNode;
		}
		if(change1 != null && prevNode != null && prevNode.val > root.val) {
			change2 = root;
		}
		prevNode = root;
		recoverTreeUtil(root.right);
	}
}
