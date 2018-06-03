class Solution {
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int row = matrix.length, col = matrix[0].length, result = 0;
		int[][] dp = new int[row][col];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(dp[r][c] == 0) dfs(matrix, dp, r, c, row, col);
				result = Math.max(result, dp[r][c]);
			}
		}
		return result;
	}
	private void dfs(int[][] matrix, int[][] dp, int r, int c, int row, int col) {
		dp[r][c] = 1;
		if(r < row-1 && matrix[r+1][c] > matrix[r][c]) {
			if(dp[r+1][c] == 0) dfs(matrix, dp, r+1, c, row, col);
			dp[r][c] = Math.max(dp[r][c], dp[r+1][c] + 1);
		}
		if(r > 0 && matrix[r-1][c] > matrix[r][c]) {
			if(dp[r-1][c] == 0) dfs(matrix, dp, r-1, c, row, col);
			dp[r][c] = Math.max(dp[r][c], dp[r-1][c] + 1);
		}
		if(c < col-1 && matrix[r][c+1] > matrix[r][c]) {
			if(dp[r][c+1] == 0) dfs(matrix, dp, r, c+1, row, col);
			dp[r][c] = Math.max(dp[r][c], dp[r][c+1] + 1);
		}
		if(c > 0 && matrix[r][c-1] > matrix[r][c]) {
			if(dp[r][c-1] == 0) dfs(matrix, dp, r, c-1, row, col);
			dp[r][c] = Math.max(dp[r][c], dp[r][c-1] + 1);   
		}
	}
}
