class Solution {
	public int mirrorReflection(int p, int q) {
		int gcd = euler(p, q);
		p /= gcd;
		q /= gcd;
		return ((q & 1) == 0) ? 0 : ((p & 1) == 0) ? 2 : 1;
	}
	public int euler(int p, int q) {
		if(q == 0) return p;
		return euler(q, p % q);
	}
}
