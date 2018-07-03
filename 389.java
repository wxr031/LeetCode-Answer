class Solution {
	public char findTheDifference(String s, String t) {
		int[] count = new int[128];
		for(char c : s.toCharArray()) {
			count[c]++;
		}
		for(char c : t.toCharArray()) {
			if(count[c]-- == 0) {
				return c;
			}
		}
		return Character.MAX_VALUE;
	}
}
