class Solution {
	public int longestSubstring(String s, int k) {
		if(s.length() == 0) return 0;
		int[][] count = new int[s.length() + 1][26], index = new int[s.length() + 1][26];
		for(int i = 0; i < s.length(); i++) {
			count[i + 1] = Arrays.copyOf(count[i], 26);
			count[i + 1][s.charAt(i) - 'a']++;
			index[s.length() - i - 1] = Arrays.copyOf(index[s.length() - i], 26);
			index[s.length() - i - 1][s.charAt(s.length() - i - 1) - 'a'] = s.length() - i - 1;
		}
		return longestSubstringUtil(s, 0, s.length() - 1, k, count, index);
	}
	private int longestSubstringUtil(String s, int begin, int end, int k, int[][] count, int[][] index) {
		if(begin > end) return 0;
		for(int c = 0; c < 26; c++) {
			if(count[end + 1][c] - count[begin][c] > 0 && count[end + 1][c] - count[begin][c] < k) {
				return Math.max(longestSubstringUtil(s, begin, index[begin][c] - 1, k, count, index),
						longestSubstringUtil(s, index[begin][c] + 1, end, k, count, index));
			}
		}
		return end - begin + 1;
	}
}
