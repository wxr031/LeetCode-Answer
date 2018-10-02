class Solution {
	public String findLongestWord(String string, List<String> d) {
		int maxLen = Integer.MIN_VALUE;
		String ans = "";
		for(String sub : d) {
			if(isSubsequence(string, sub) && (sub.length() > maxLen
						|| sub.length() == maxLen && sub.compareTo(ans) < 0)) {
				maxLen = sub.length();
				ans = sub;
			}
		}
		return ans;
	}
	boolean isSubsequence(String string, String sub) {
		int j = 0;
		for(int i = 0; i < string.length() && j < sub.length(); i++) {
			if(string.charAt(i) == sub.charAt(j)) {
				j++;
			}
		}
		return j == sub.length();
	}
}
