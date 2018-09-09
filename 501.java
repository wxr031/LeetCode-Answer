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
	ArrayList<Integer> list = new ArrayList<>();
	Integer prev = null;
	int count = 0, maxCount = -1;
	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];
		inorder(root);
		process(null);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	private void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		process(root.val);
		inorder(root.right);
	}
	private void process(Integer curr) {
		if(prev == null || curr == null || !prev.equals(curr)) {
			if(count == maxCount) {
				list.add(prev);
			}
			else if(count > maxCount){
				list.clear();
				list.add(prev);
				maxCount = count;
			}
			count = 1;
			prev = curr;
		}
		else {
			count++;
		}
	}
}
