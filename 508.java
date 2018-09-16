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
	int maxFreq = 0;
	ArrayList<Integer> list = new ArrayList<>();
	public int[] findFrequentTreeSum(TreeNode root) {
		HashMap<Integer, Integer> map = new HashMap();
		postOrder(root, map);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	public int postOrder(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null) return 0;
		int sum = postOrder(root.left, map) + postOrder(root.right, map) + root.val;
		int freq = map.getOrDefault(sum, 0) + 1;
		map.put(sum, freq);
		if(freq >= maxFreq) {
			if(freq > maxFreq) {
				list.clear();
				maxFreq = freq;
			}
			list.add(sum);
		}
		return sum;
	}
}
