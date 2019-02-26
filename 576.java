class Solution {
	public int findPaths(int row, int col, int N, int initR, int initC) {
		final int MOD = 1000000007;
		long[][][] dp = new long[row + 2][col + 2][2];
		dp[initR + 1][initC + 1][0] = 1;

		long[][] exitNum = new long[row + 2][col + 2];
		for (int r = 1; r <= row; r++) {
			for (int c = 1; c <= col; c++) {
				exitNum[r][c] = (r == 1 ? 1 : 0) + (r == row ? 1 : 0)
					+ (c == 1 ? 1 : 0) + (c == col ? 1 : 0);
			}
		}

		long count = 0;
		for (int k = 0; k < N; k++) {
			int now = k & 1, next = now ^ 1;
			for (int r = 1; r <= row; r++) {
				for (int c = 1; c <= col; c++) {
					if (r == 1 || r == row || c == 1 || c == col) {
						count = (count + exitNum[r][c] * dp[r][c][now]) % MOD;
					}
					dp[r][c][next] = (dp[r - 1][c][now] + dp[r + 1][c][now]
							+ dp[r][c - 1][now] + dp[r][c + 1][now]) % MOD;
				}
			}
		}
		return (int)count;
	}
}
