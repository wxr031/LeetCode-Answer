class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums == null || nums.length == 0) return new ArrayList<Integer>();
		Arrays.sort(nums);
		int[] dp = new int[nums.length], prev = new int[nums.length];
		int maxLength = 1, maxIndex = 0;
		for(int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			prev[i] = -1;
			for(int j = 0; j < i; j++) {
				if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if(dp[i] > maxLength) {
				maxLength = dp[i];
				maxIndex = i;
			}
		}
		List<Integer> result = new ArrayList<>();
		for(int start = maxIndex; start != -1; start = prev[start]) {
			result.add(nums[start]);
		}
		return result;
	}
}
