public class Solution {
	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length() + 1];
		int maxLength = 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) == ')') {
				if (s.charAt(i - 2) == '(') {
					dp[i] = dp[i - 2] + 2;
				}
				else if (i > dp[i - 1] + 1 && s.charAt(i - 2) == ')' && s.charAt(i - dp[i - 1] - 2) == '(') {
					dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}
}
