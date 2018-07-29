class Solution {
	public double myPow(double x, int n) {
		if(n == 0) return 1.0;
		if(n == -1) return 1.0 / x;
		return ((n & 1) == 1) ? x * myPow(x, n - 1) : myPow(x * x, n / 2);
	}
}
