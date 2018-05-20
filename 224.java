class Solution {
	public int calculate(String string) {
		Stack<Integer> istack = new Stack<>();
		Stack<Boolean> bstack = new Stack<>();
		boolean pos = true;
		int abs = 0, result = 0;
		for(char ch : string.toCharArray()) {
			switch(ch) {
				case '+':
				case '-': result += pos ? abs : -abs;
						  pos = ch == '+';
						  abs = 0;
						  break;
				case '(': istack.push(result);
						  bstack.push(pos);
						  pos = true;
						  abs = 0;
						  result = 0;
						  break;
				case ')': result += pos ? abs : -abs;
						  result = istack.pop() + ((bstack.pop()) ? result : -result);
						  pos = true;
						  abs = 0;
						  break;
				case ' ': break;
				default:  abs = abs * 10 + ch - '0';
						  break;
			}
		}
		result += pos ? abs : -abs;
		return result;
	}
}
