class Solution {
	public int longestPalindrome(String s) {
		int[] letters = new int[128];
		for (int i = 0; i < s.length(); i++){
			letters[s.charAt(i)]++;
		}
		int result = 0;
		for(int i = 'A'; i <= 'Z'; i++) {
			result += letters[i] / 2 * 2;
		}
		for (int i = 'a'; i <= 'z'; i++){
			result += letters[i] / 2 * 2;
		}
		return result == s.length() ? result : result + 1;
	}
}
