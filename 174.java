class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int length = dungeon.length, width = dungeon[0].length;
		int[][] dp = new int[length + 1][width + 1];
		Arrays.fill(dp[length], Integer.MAX_VALUE);
		dp[length][width - 1] = 1;
		for (int i = length - 1; i >= 0; i--) {
			dp[i][width] = Integer.MAX_VALUE;
			for (int j = width - 1; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
				if(dp[i][j] <= 0) {
					dp[i][j] = 1;
				}
			}
		}
		return dp[0][0];
	}
}
