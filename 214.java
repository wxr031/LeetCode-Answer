class Solution {
	public String shortestPalindrome(String s) {
		if(s == null || s.length() == 0) return "";
		StringBuilder sb = new StringBuilder(s);
		sb.append('?'); // separator
		sb.append(new StringBuilder(s).reverse());
		int i = 1, j = 0;
		// KMP prefix table
		int[] pi = new int[sb.length()];
		while(i < sb.length()) {
			if(sb.charAt(i) == sb.charAt(j)) pi[i++] = ++j;
			else if(j > 0) j = pi[j-1];
			else pi[i++] = 0;
		}
		return sb.append(sb, pi[sb.length()-1], s.length()).delete(0, s.length()+1).toString();
	}
}
