class Solution {
	public int findMaxForm(String[] strs, int num0, int num1) {
		int[][] dp = new int[num0 + 1][num1 + 1];
		for(int i = 0; i < strs.length; i++) {
			int[] bits = new int[2];
			for(char c : strs[i].toCharArray()) {
				bits[c - '0']++;
			}
			for(int n0 = num0; n0 >= bits[0]; n0--) {
				for(int n1 = num1; n1 >= bits[1]; n1--) {
					dp[n0][n1] = Math.max(dp[n0][n1], dp[n0 - bits[0]][n1 - bits[1]] + 1);
				}
			}
		}
		return dp[num0][num1];
	}
}
