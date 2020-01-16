class Solution {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int[] pt = new int[needle.length()];
		int i = 0, j = 0;
		prefixTable(pt);
		while (j < haystack.length()) {
			if (needle.charAt(i) == haystack.charAt(j)) {
				if (i == needle.length() - 1) {
					return j - needle.length() + 1;
				}
				i++;
				j++;
			}
			else if (i > 0) {
				i = pt[i - 1];
			}
			else {
				j++;
			}
		}
		return -1;
	}
	private void prefixTable(int[] pt, String[] pattern) {
		int i = 0, j = 1;
		pt[0] = 0;
		while (j < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pt[j++] = ++i;
			}
			else if (i > 0) {
				i = pt[i - 1];
			}
			else {
				pt[j++] = 0;
			}
		}
	}
}
