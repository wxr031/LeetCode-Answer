class Solution {
	public int countNumbersWithUniqueDigits(int n) {
		int[] answer = new int[11];
		answer[0] = 1;
		answer[1] = 10;
		int accum = 9;
		for(int i = 2; i <= 10; i++) {
			accum *= (10 - i + 1);
			answer[i] = answer[i - 1] + accum;
		}
		return answer[Math.min(n, 10)];
	}
}
