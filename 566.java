class Solution {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums == null || nums[0] == null || nums.length * nums[0].length != r * c) {
			return nums;
		}
		int ro = nums.length, co = nums[0].length;
		int[][] newMatrix = new int[r][c];
		for (int i = 0; i < r * c; i++) {
			newMatrix[i / c][i % c] = nums[i / co][i % co];
		}
		return newMatrix;
	}
}
