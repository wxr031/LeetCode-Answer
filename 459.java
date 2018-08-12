class Solution {
	public boolean repeatedSubstringPattern(String string) {
		int len = string.length();
		int[] pi = new int[len];
		pi[0] = 0;
		for(int i = 1, j = 0; i < len;) {
			if(string.charAt(i) == string.charAt(j)) {
				pi[i++] = ++j;
			}
			else if(j > 0) {
				j = pi[j - 1];
			}
			else {
				pi[i++] = 0;
			}
		}
		return pi[len - 1] != 0 && pi[len - 1] % (len - pi[len - 1]) == 0;
	}
}