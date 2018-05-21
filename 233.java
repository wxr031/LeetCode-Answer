class Solution {
	public int countDigitOne(int n) {
		int result = 0;
		for(long pow = 1; pow <= n; pow *= 10) {
			long pre = n / pow;
			result += (pre + 8) / 10 * pow;
			if(pre % 10 == 1) {
				result += n % pow + 1;
			}
		}
		return result;
	}
}
