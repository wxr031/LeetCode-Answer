class Solution {
	public String fractionAddition(String expression) {
		List<Character> ops = new ArrayList<>();
		String[] fracs = expression.split("\\+|-");
		if (expression.charAt(0) == '-') {
			ops.add('-');
		}
		else {
			ops.add('+');
		}
		for (int i = 1; i < expression.length(); i++) {
			char curr = expression.charAt(i);
			if (curr == '-' || curr == '+') {
				ops.add(curr);
			}
		}
		int[] result = new int[] {0, 1};
		int now = 0;
		for (String frac : fracs) {
			if (frac.length() == 0)
				continue;
			int[] fracInt = Arrays.stream(frac.split("/")).mapToInt(Integer::parseInt).toArray();
			if (ops.get(now++) == '-') {
				fracInt[0] = -fracInt[0];
			}
			result[0] = result[0] * fracInt[1] + result[1] * fracInt[0];
			result[1] = result[1] * fracInt[1];
			int gcd = getGCD(Math.abs(result[0]), Math.abs(result[1]));
			result[0] /= gcd;
			result[1] /= gcd;
		}
		StringBuilder sb = new StringBuilder();
		return sb.append(result[0]).append('/').append(result[1]).toString();
	}
	private int getGCD(int a, int b) {
		if (b == 0)
			return a;
		return getGCD(b, a % b);
	}
}
