class Solution {
	public int findNthDigit(int n) {
		if(n <= 9) return n;
		int[] pow10 = new int[] {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
		int[] accum = new int[] {0, 10, 180, 2700, 36000, 450000, 5400000, 63000000, 720000000};
		int i = 1;
		while(i < 9 && n >= accum[i]) {
			n -= accum[i++];
		}
		return (n / (i * pow10[i - (n % i) - 1]) + ((n % i == 0) ? 1 : 0)) % 10;
	}
}
