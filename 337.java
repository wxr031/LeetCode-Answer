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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
		return Math.max(result[0], result[1]);
    }
	private int[] dfs(TreeNode root) {
		if(root == null) return new int[] {0, 0};
		int[] robLeft = dfs(root.left), robRight = dfs(root.right);
		return new int[] {robLeft[1] + robRight[1] + root.val,
                          Math.max(robLeft[0] + robRight[0], Math.max(robLeft[0] + robRight[1],
                                            Math.max(robLeft[1] + robRight[0], robLeft[1] + robRight[1])))};
	}
}
