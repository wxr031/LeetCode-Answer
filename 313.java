class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] min = new int[primes.length], pointer = new int[primes.length];
		int[] dp = new int[n+1];
		Arrays.fill(min, 1);
		for(int i = 0; i <= n; i++) {
			int minValue = Integer.MAX_VALUE;
			for(int j = 0; j < min.length; j++)
				if(min[j] < minValue)
					minValue = min[j];
			dp[i] = minValue;
			for(int j = 0; j < min.length; j++) 
				if(min[j] == minValue)
					min[j] = primes[j] * dp[pointer[j]++];
		}
		return dp[n-1];
	}
}
