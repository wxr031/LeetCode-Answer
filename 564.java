class Solution {
	public String nearestPalindromic(String n) {
		long num = Long.parseLong(n), tens = pow10(n.length() / 2);
		/* Exception: when num = 1000, palindrome(num - tens) = 909, but 999 is closer */
		long low = log10Long(num - tens) < log10Long(num) ? pow10(log10Long(num)) - 1 : palindrome(num - tens);
		long mid = palindrome(num), high = palindrome(num + tens);
		long diffLow = getDiff(num, low), diffMid = getDiff(num, mid), diffHigh = getDiff(num, high);
		if(diffLow <= diffMid) {
			return (diffLow <= diffHigh) ? String.valueOf(low) : String.valueOf(high);
		}
		else {
			return (diffMid <= diffHigh) ? String.valueOf(mid) : String.valueOf(high);
		}
	}
	private long pow10(long len) {
		long ten = 1;
		for(long i = 0; i < len; i++) {
			ten *= 10;
		}
		return ten;
	}
	private long palindrome(long num) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		int len = sb.length();
		for(int i = 0; i < len / 2; i++) {
			sb.setCharAt(len - i - 1, sb.charAt(i));
		}
		return Long.parseLong(sb.toString());
	}
	private long getDiff(long num1, long num2) {
		return (num1 == num2) ? Long.MAX_VALUE : Math.abs(num1 - num2);
	}
	private long log10Long(long num) {
		return (long)(Math.log10((double)num));
	}
}
