class Solution {
	public int getSum(int num1, int num2) {
		int result = 0, carry = 0, shift = 0;
		for(; shift < 32; shift++, num1 >>= 1, num2 >>= 1) {
			int a = num1 & 1, b = num2 & 1;
			result |= ((a ^ b ^ carry) << shift);
			carry = (a & b) | (carry & (a | b));
		}
		return result | (carry << shift);
	}
}
