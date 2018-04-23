class Solution {
	public int expand(String string, int len, int center, int distance) {
		int left = center - distance, right = center + distance;
		while(left >= 0 && right < len && string.charAt(left) == string.charAt(right)) {
			left--;
			right++;
		}
		return right - center - 1;
	}
	public String longestPalindrome(String string) {
		if(string == null || string.length() <= 1) return string;

		/* create auxiliary string */
		int newLength = string.length() * 2 + 1;
		char[] array = new char[newLength];
		for(int i = 0; i < string.length(); i++) {
			array[2*i] = '?';
			array[2*i+1] = string.charAt(i);
		}
		array[newLength-1] = '?';
		String newString = new String(array);

		/* create palindrome table */
		int[] table = new int[newLength];
		table[0] = 0;
		table[1] = 1;
		int center = 1, distance = 1;

		/* Manacher's algorithm */
		int maxPalindromeLength = Integer.MIN_VALUE, maxPalindromeId = -1;
		for(int i = 2; i < newLength; ++i) {
			int mirror = 2 * center - i;
			int rightBound = center + distance, rightDist = rightBound - i;
			if(i >= rightBound) {
				center = i;
				table[i] = expand(newString, newLength, center, 1);
				distance = table[i];
			} else if(table[mirror] == rightDist) {
				center = i;
				table[i] = expand(newString, newLength, center, table[mirror]);
				distance = table[i];
			} else {
				table[i] = Math.min(rightDist, table[mirror]);
			}

			if(table[i] > maxPalindromeLength) {
				maxPalindromeLength = table[i];
				maxPalindromeId = i;
			}
		}
		int resultLength = (maxPalindromeLength-1)/2, resultCenter = (maxPalindromeId-1)/2;
		return string.substring(resultCenter-resultLength, resultCenter-resultLength+maxPalindromeLength);
	}
}
