class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int accum = 0, result = 0;
		for(int i = 2; i < A.length; i++) {
			if(A[i] + A[i - 2] == (A[i - 1] << 1)) {
				accum++;
				result += accum;
			}
			else {
				accum = 0;
			}
		}
		return result;
	}
}
