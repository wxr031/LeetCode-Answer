class Solution {
	public int checkRecord(int n) {
		long[] dp = new long[6];
		final long MOD = 1000000007;
		dp[0] = dp[1] = dp[3] = 1;
		for(int i = 1; i < n; i++) {
			long noA = 0, all = 0;
			for(int j = 0; j < 3; j++) {
				noA += dp[j];
				all += dp[j] + dp[j + 3];
			}
			dp[2] = dp[1];
			dp[1] = dp[0];
			dp[5] = dp[4];
			dp[4] = dp[3];
			dp[0] = noA % MOD;
			dp[3] = all % MOD;
		}
		long result = 0;
		for(int i = 0; i < 6; i++) result += dp[i];
		return (int)(result % MOD);
	}
}
