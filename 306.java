import java.math.BigInteger;
class Solution {
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		for(int i = 1; i <= (len >> 1); i++) {
			for(int j = i + 1; Math.max(i, j - i) <= len - j; j++) {
				if((i > 1 && num.charAt(0) == '0') || (j - i > 1 && num.charAt(i) == '0'))
					continue;
				BigInteger num1 = new BigInteger(num.substring(0, i));
				BigInteger num2 = new BigInteger(num.substring(i, j));
				int end = j;
				while(end < len) {
					num2 = num2.add(num1);
					num1 = num2.subtract(num1);
					String next = num2.toString();
					if(!num.startsWith(next, end)) break;
					end += next.length();
				}
				if(end == len)
					return true;
			}
		}
		return false;
	}
}
