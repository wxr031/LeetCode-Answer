class Solution {
	public int findTargetSumWays(int[] nums, int sum) {
		int total = 0;
		for(int num : nums) total += num;
		sum = Math.abs(sum);
		if(total < sum || ((total - sum) & 1) != 0) return 0;
		int subsetSum = (total - sum) >> 1;
		int[] dp = new int[subsetSum + 1];
		dp[0] = 1;
		for(int i = 1; i <= nums.length; i++) {
			for(int j = subsetSum; j >= nums[i - 1]; j--) {
				dp[j] += dp[j - nums[i - 1]];
			}
		}
		return dp[subsetSum];
	}
}
