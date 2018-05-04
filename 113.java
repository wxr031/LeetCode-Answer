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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		pathSumUtil(result, temp, root, sum, 0);
		return result;
	}
	public void pathSumUtil(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum, int currSum) {
		if(root == null) {
			return;
		}
		temp.add(root.val);
		currSum += root.val;
		if(root.left == null && root.right == null) {
			if(currSum == sum) {
				result.add(new ArrayList<Integer>(temp));
			}
			temp.remove(temp.size()-1);
			return;
		}
		pathSumUtil(result, temp, root.left, sum, currSum);
		pathSumUtil(result, temp, root.right, sum, currSum);
		temp.remove(temp.size()-1);
	}
}
