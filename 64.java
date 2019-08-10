class Solution {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;
		int[][] dp = new int[row + 1][column + 1];
		Arrays.fill(dp[0], Integer.MAX_VALUE);
		dp[0][1] = 0;
		for (int i = 1; i <= row; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			for (int j = 1; j <= column; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
			}
		}
		return dp[row][column];
	}
}
