class Solution {
	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		for(int k = 2; k <= n; k++) {
			int i, j;
			int len = sb.length();
			for(i = 0; i < len; i = j) {
				j = i+1;
				while(j < len && sb.charAt(i) == sb.charAt(j))
					j++;
				sb.append((char)(j-i+'0'));
				sb.append(sb.charAt(i));
			}
			sb.delete(0, len);
		}
		return sb.toString();
	}
}
