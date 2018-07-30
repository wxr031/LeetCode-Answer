class Solution {
	public int divide(int dividend, int divisor) {
		/* Special case: when dividend = Integer.MIN_VALUE, divisor = -1,
		   this function returns Integer.MIN_VALUE, but the result should be Integer.MAX_VALUE.*/
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		/* Do division with both of their absolute value first */
		int dividendAbs = Math.abs(dividend), divisorAbs = Math.abs(divisor), result = 0;
		for (int n = 31; n >= 0; n--) {
			if ((dividendAbs >>> n) - divisorAbs >= 0) {
				result += 1 << n;
				dividendAbs -= divisorAbs << n;
			}
		} 
		/* Determine the sign of result */
		return (dividend > 0) == (divisor > 0) ? result : -result;
	}
}
