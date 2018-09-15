class Solution {
	public boolean xorGame(int[] nums) {
		int init = 0;
		for (int num : nums) init ^= num;
		return init == 0 || nums.length % 2 == 0;
	}
}
