import java.util.*;

class Solution {
	public static int scoreOfParentheses(String string) {
		int layer = -1, result = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '(') layer++;
			else {
				if(string.charAt(i - 1) == '(') {
					result += (1 << layer);
				}
				layer--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		System.out.println(scoreOfParentheses(string));
	}
}
