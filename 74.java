class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int length = matrix.length, width = matrix[0].length;
		int left = 0, right = length * width - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / width, col = mid % width;
			if(matrix[row][col] < target)
				left = mid + 1;
			else if(matrix[row][col] > target)
				right = mid - 1;
			else return true;
		}
		return false;
	}
}
