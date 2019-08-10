class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		int[][] dp = new int[row + 1][column + 1];
		dp[0][1] = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (obstacleGrid[i - 1][j - 1] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[row][column];
	}
}
