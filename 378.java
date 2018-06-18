class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int left = matrix[0][0] - 1, right = matrix[matrix.length - 1][matrix.length - 1];
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if(countPrevious(matrix, mid) >= k) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		return right;
	}
	private int countPrevious(int[][] matrix, int curr) {
		int total = 0, j = matrix.length - 1;
		for(int i = 0; i < matrix.length && j >= 0; i++) {
			while(j >= 0 && matrix[i][j] > curr) {
				j--;
			}
			total += j + 1;
		}
		return total;
	}
}
