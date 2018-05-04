class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] dp = new int[triangle.size() + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = triangle.get(0).get(0);
		for(int i = 2; i <= triangle.size(); i++) {
			for(int j = i; j > 0; j--) {
				dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i-1).get(j-1);
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= triangle.size(); i++) {
			result = Math.min(result, dp[i]);
		}
		return result;
	}
}
