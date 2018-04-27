class Solution {
	public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		int len = s1.length();
		boolean[][][] dp = new boolean[len][len][len+1];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
			}
		}
		for(int l = 2; l <= len; l++) {
            for(int k = 1; k < l; k++) {
			    for(int i = 0; i < len-k; i++) {
				    for(int j = 0; j < len-l+k && j < len-k; j++) {
						dp[i][j][l] = dp[i][j][l] || (dp[i][j][k] && dp[i+k][j+k][l-k])
							|| (dp[i][j+l-k][k] && dp[i+k][j][l-k]);
					}
				}
			}
		}
		return dp[0][0][len];
	}
}


