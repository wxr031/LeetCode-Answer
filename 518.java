class Solution {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for(int i = 0; i < coins.length; i++) {
			for(int s = 1; s <= amount; s++) {
				if(s >= coins[i]) {
					dp[s] += dp[s - coins[i]];
				}
			}
		}
		return dp[amount];
	}
}
