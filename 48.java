class Solution {
	public static void rotate(int[][] matrix) {
		int width = matrix.length;
		int start = 0;
		while (width > 1) {
			for (int i = 0; i < width - 1; i++) {
				int temp = matrix[start][start + i];
				matrix[start][start + i] = matrix[start + width - i - 1][start];
				matrix[start + width - i - 1][start] = matrix[start + width - 1][start + width - i - 1];
				matrix[start + width - 1][start + width - i - 1] = matrix[start + i][start + width - 1];
				matrix[start + i][start + width - 1] = temp;
			}
			start++;
			width -= 2;
		}
	}
}
