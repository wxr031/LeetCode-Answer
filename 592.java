class Solution {
	public String fractionAddition(String expression) {
		long[] result = new long[] {0, 1};
		long[] temp = new long[] {0, 0};
		int curr = 0, sign = 1, pos = 0;
		char letter;
		while (curr < expression.length()) {
			letter = expression.charAt(curr);
			if (letter == '-') {
				if (pos == 0) {
					sign *= -1;
				}
				else {
					/* calculate result */
					calculate(result, temp);
					temp[0] = temp[1] = 0;
					pos = 0;
					sign = -1;
				}
			}
			else if (letter == '+') {
				calculate(result, temp);
				temp[0] = temp[1] = 0;
				pos = 0;
				sign = 1;
			}
			else if (Character.isDigit(letter)) {
				temp[pos] = temp[pos] * 10 + Character.getNumericValue(letter);
			}
			else if (letter == '/') {
				temp[pos] *= sign;
				pos = 1;
				sign = 1;
			}
			else {
				return null;
			}
			curr++;
		}
		calculate(result, temp);
		StringBuilder sb = new StringBuilder();
		sb.append(result[0]).append('/').append(result[1]);
		return sb.toString();
	}
	private void calculate(long[] result, long[] temp) {
		result[0] = result[0] * temp[1] + result[1] * temp[0];
		result[1] = result[1] * temp[1];
		long gcdResult = gcd(Math.abs(result[0]), Math.abs(result[1]));
		result[0] /= gcdResult;
		result[1] /= gcdResult;
	}
	private long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
