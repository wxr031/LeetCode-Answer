class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		if(words.length <= 1) return new ArrayList<String>();
		Arrays.sort(words, (String str1, String str2) -> {return str1.length() - str2.length();});
		HashSet<String> set = new HashSet<>();
		List<String> result = new ArrayList<>();
		for(String word : words) {
			if(word.length() == 0) {
				continue;
			}
			boolean[] dp = new boolean[word.length() + 1];
			dp[0] = true;
			for(int curr = 1; curr <= word.length(); curr++) {
				for(int prev = 0; prev < curr; prev++) {
					if(dp[prev] && set.contains(word.substring(prev, curr))) {
						dp[curr] = true;
						break;
					}
				}
			}
			if(dp[word.length()]) {
				result.add(word);
			}
			set.add(word);
		}
		return result;
	}
}
