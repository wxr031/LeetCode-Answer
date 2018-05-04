class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() == 0) {
			return 0;
		}
		int[] dp = new int[triangle.size() + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = triangle.get(0).get(0);
		for(int i = 2; i <= triangle.size(); i++) {
			for(int j = i; j > 0; j--) {
				dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i-1).get(j-1);
			}
		}
		return dp[triangle.size()];
	}
}

