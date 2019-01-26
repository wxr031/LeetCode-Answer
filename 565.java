class Solution {
	public int arrayNesting(int[] nums) {
		int maxLength = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= 0) {
				maxLength = Math.max(dfs(i, nums, 0), maxLength);
			}
		}
		return maxLength;
	}
	private int dfs(int i, int[] nums, int count) {
		if(nums[i] < 0) {
			return count;
		}
		int n = nums[i];
		nums[i] = -nums[i] - 1;
		return dfs(n, nums, count + 1);
	}
}
