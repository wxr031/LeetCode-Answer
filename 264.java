class Solution {
	public static final int MAXN = 1690;
	public int nthUglyNumber(int n) {
		int num2 = 1, num3 = 1, num5 = 1;
		int min2 = 0, min3 = 0, min5 = 0;
		int[] minNum = new int[MAXN];
		for(int i = 0; i < n; i++) {
			minNum[i] = Math.min(num2, Math.min(num3, num5));
			if(minNum[i] == num2) num2 = 2 * minNum[min2++];
			if(minNum[i] == num3) num3 = 3 * minNum[min3++];
			if(minNum[i] == num5) num5 = 5 * minNum[min5++];
		}
		return minNum[n-1];
	}
}
