class Solution {
	public int minCut(String s) {
		int[] dp = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			dp[i] = i;
		}
		for(int i = 0; i < s.length(); i++) {
			expand(dp, i, i, s);
			expand(dp, i, i+1, s);
		}
		return dp[s.length()-1];
	}
	public void expand(int[] dp, int left, int right, String s) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			dp[right] = Math.min(dp[right], (left != 0) ? dp[left-1] + 1 : 0);
			left--;
			right++;
		}
	}
}
