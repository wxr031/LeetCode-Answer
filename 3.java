class Solution {
	public int lengthOfLongestSubstring(String string) {
		boolean[] hash = new boolean[256];
		int left = 0, right = 0;
		int result = -1;

		for(right = 0; right < string.length(); right++) {
			char pos = string.charAt(right);
			if(hash[pos]) {
				result = Math.max(result, right-left);
				int left_pos;
				while((left_pos = string.charAt(left++)) != pos) {
					hash[left_pos] = false;
				}
			}
			else {
				hash[pos] = true;
			}
		}
		result = Math.max(result, right-left);
		return result;
	}
}
