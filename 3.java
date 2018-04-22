class Solution {
    public static final int CHAR_NUM = 256;
	public int lengthOfLongestSubstring(String string) {
		boolean[] hash = new boolean[CHAR_NUM];
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
