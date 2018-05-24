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
    public int countNodes(TreeNode root) {
		if(root == null) return 0;
        int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
		return (leftHeight == rightHeight)
			? (1 << leftHeight) + countNodes(root.right)
			: (1 << rightHeight) + countNodes(root.left);
    }
	public int getHeight(TreeNode root) {
		if(root == null) return 0;
		return 1 + getHeight(root.left);
	}
}
