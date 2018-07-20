class Solution {
	private static class TrieNode {
		TrieNode[] child;
		int num;

		TrieNode() {
			child = new TrieNode[2];
		}
		public void insert(TrieNode curr, int num, int mask) {
			if(mask == 0) {
				curr.num = num;
				return;
			}
			int bit = (num & mask) == 0 ? 0 : 1;
			if(curr.child[bit] == null) {
				curr.child[bit] = new TrieNode();
			}
			insert(curr.child[bit], num, mask >>> 1);
		}
		public int search(TrieNode curr, int num, int mask) {
			if(mask == 0) {
				return curr.num;
			}
			int bit = (num & mask) == 0 ? 1 : 0;
			if(curr.child[bit] == null) {
				bit ^= 1;
			}
			return search(curr.child[bit], num, mask >>> 1);
		}
	}
	public int findMaximumXOR(int[] nums) {
		if(nums.length <= 1) {
			return 0;
		}
		TrieNode root = new TrieNode();
		int result = -1;
		root.insert(root, nums[0], 1 << 31);
		for(int i = 1; i < nums.length; i++) {
			result = Math.max(result, nums[i] ^ root.search(root, nums[i], 1 << 31));
			root.insert(root, nums[i], 1 << 31);
		}
		return result;
	}
}
