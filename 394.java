class Solution {
	public String decodeString(String s) {
		int[] nextBracket = new int[s.length()], stack = new int[s.length()];
		int top = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '[') stack[top++] = i;
			else if(s.charAt(i) == ']') nextBracket[stack[--top]] = i;
		}
		return decodeStringUtil(s, 0, s.length(), nextBracket);
	}
	private String decodeStringUtil(String s, int start, int finish, int[] nextBracket) {
		StringBuilder sb = new StringBuilder();
		int i = start, num = 0;
		while(i < finish) {
			if(Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i++) - '0';
			}
			else if(s.charAt(i) == '[') {
				String sub = decodeStringUtil(s, i + 1, nextBracket[i], nextBracket);
				while(num > 0) {
					sb.append(sub);
					num--;
				}
				i = nextBracket[i] + 1;
			}
			else {
				sb.append(s.charAt(i++));
			}
		}
		return sb.toString();
	}
}
