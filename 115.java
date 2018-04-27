class Solution {
	public int numDistinct(String s, String t) {
		if(s == null || t == null || s.length() < t.length())
			return 0;
		if(t.length() == 0)
			return 1;
		int[][] dp = new int[s.length()][t.length()];
		dp[0][0] = ((s.charAt(0) == t.charAt(0)) ? 1 : 0);
		for(int i = 1; i < s.length(); i++) {
			dp[i][0] = dp[i-1][0] + ((s.charAt(i) == t.charAt(0)) ? 1 : 0);
		}
		for(int i = 1; i < s.length(); i++) {
			for(int j = 1; j <= Math.min(i, t.length()-1); j++) {
				if(s.charAt(i) == t.charAt(j)) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[s.length()-1][t.length()-1];
	}
}

