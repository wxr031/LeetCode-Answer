class Solution {
	public int maxCoins(int[] nums) {
		int[] balloons = new int[nums.length + 2];
		balloons[0] = balloons[nums.length + 1] = 1;
		System.arraycopy(nums, 0, balloons, 1, nums.length);
		int[][] dp = new int[balloons.length][balloons.length];
		for(int gap = 2; gap < balloons.length; gap++) {
			for(int i = 0; i < balloons.length - gap; i++) {
				int j = i + gap;
				for(int k = i + 1; k < j; k++) {
					dp[i][j] = Math.max(balloons[i] * balloons[j] * balloons[k]
							+ dp[i][k] + dp[k][j], dp[i][j]);
				}
			}
		}
		return dp[0][balloons.length - 1];
	}
}
