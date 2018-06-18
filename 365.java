class Solution {
	public boolean canMeasureWater(int x, int y, int z) {
		if(z > x + y || z < 0) return false;
		int gcd = euclidean(x, y);
		return gcd == 0 ? z == 0 : z % gcd == 0;
	}
	private int euclidean(int x, int y) {
		if(y == 0) return x;
		return euclidean(y, x % y);
	}
}
