class Solution {
	public int calculate(String string) {
		string += '?'; // dummy sign
		int start = 0, num = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if(Character.isDigit(ch)) {
				num = num * 10 + Character.getNumericValue(ch);
			}
			else if(ch != ' ') {
				switch (sign) {
					case '+': stack.push(num); break;
					case '-': stack.push(-num); break;
					case '*': stack.push(stack.pop() * num); break;
					case '/': assert num != 0; stack.push(stack.pop() / num); break;
				}
				sign = ch;
				num = 0;
			}
		}
		int sum = 0;
		for(Integer temp : stack) sum += temp;
		return sum;
	}
}

