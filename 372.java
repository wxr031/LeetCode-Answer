class Solution {
	private static final int MOD = 1337;
	public int superPow(int a, int[] b) {
		long result = 1;
		a %= MOD;
		int[] dp = new int[10];
		dp[0] = 1;
		for(int i = 1; i < 10; i++) {
			dp[i] = (dp[i - 1] * a) % MOD;
		}
		for(int n : b) {
			result = (pow10(result) * dp[n]) % MOD;
		}
		return (int)result;
	}
	public long pow10(long a) {
		long two = (a * a) % MOD, four = (two * two) % MOD, eight = (four * four) % MOD;
		return (two * eight) % MOD;
	}
}
