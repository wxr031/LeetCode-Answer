class Solution {
	public String removeKdigits(String num, int k) {
		char[] stack = new char[num.length()];
		int top = -1, len = num.length() - k;
		for(int i = 0; i < num.length(); i++) {
			while(k > 0 && top >= 0 && stack[top] > num.charAt(i)) {
				top--;
				k--;
			}
			stack[++top] = num.charAt(i);
		}
		int begin = 0;
		while(begin < len && stack[begin] == '0') {
			begin++;
		}
		if(begin == len) {
			return "0";
		}
		return new String(stack, begin, len - begin);
	}
}
