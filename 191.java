public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int bits = 0;
		while(n != 0) {
			bits += (n & 1);
			n >>>= 1;
		}
		return bits;
	}
}
