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
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		preorder(root, result, 0);
		return result;
	}
	public void preorder(TreeNode root, List<Integer> result, int depth) {
		if(root == null) return;
		if(result.size() == depth) {
			result.add(root.val);
		}
		else {
			result.set(depth, root.val);
		}
		preorder(root.left, result, depth+1);
		preorder(root.right, result, depth+1);
	}
}
