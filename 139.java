class Solution {
	public boolean wordBreak(String string, List<String> wordDict) {
		boolean[] dp = new boolean[string.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= string.length(); i++) {
            for(int j = 0; j < wordDict.size() && !dp[i]; j++) {
                int prev = i - wordDict.get(j).length();
                dp[i] = ((prev >= 0) && dp[prev] && (string.substring(prev, i).equals(wordDict.get(j))));
            }
        }
        return dp[string.length()];
	}
}
