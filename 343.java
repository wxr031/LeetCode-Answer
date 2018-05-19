class Solution {
	public int integerBreak(int n) {
		if(n % 3 == 0) return power3(n / 3);
		else if(n % 3 == 1) return 4 * power3((n / 3) - 1);
		else return 2 * power3(n / 3);
	}
	int power3(int x) {
		int result = 1;
		while(x-- > 0) result *= 3;
		return result;
	}
}
