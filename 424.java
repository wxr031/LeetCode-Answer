class Solution {
	public int characterReplacement(String string, int k) {
		int left = 0, right = 0, maxSameChar = 0, maxLength = 0;
		int[] count = new int[128];
		while(right < string.length()) {
			maxSameChar = Math.max(maxSameChar, ++count[string.charAt(right)]);
			while(right - left + 1 - maxSameChar > k) {
				count[string.charAt(left++)]--;
			}
			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}
}
