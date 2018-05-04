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
	public List<TreeNode> generateTrees(int num) {
		if(num == 0) return new ArrayList<TreeNode>();
		List<List<TreeNode>> dp = new ArrayList<>();
		for(int i = 0; i <= num; i++) {
			dp.add(new ArrayList<TreeNode>());
		}
		dp.get(0).add(null);
		for(int n = 1; n <= num; n++) {
			for(int r = 1; r <= n; r++) {
				for(TreeNode leftTree : dp.get(r-1)) {
					for(TreeNode rightTree : dp.get(n-r)) {
						TreeNode root = new TreeNode(r);
						root.left = leftTree;
						root.right = copyOf(rightTree, r);
						dp.get(n).add(root);
					}
				}
			}
		}
		return dp.get(num);
	}
	public TreeNode copyOf(TreeNode root, int add) {
		if(root == null) {
			return null;
		}
		TreeNode newNode = new TreeNode(root.val + add);
		newNode.left = copyOf(root.left, add);
		newNode.right = copyOf(root.right, add);
		return newNode;
	}
}
