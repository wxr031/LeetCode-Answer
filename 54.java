class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix.length == 0) return result;
		int length = matrix.length, width = matrix[0].length;
		int start = 0;
		while(length > 1 && width > 1) {
			for(int i = 0; i < width; i++) {
				result.add(matrix[start][start+i]);
			}
			for(int i = 1; i < length-1; i++) {
				result.add(matrix[start+i][start+width-1]);
			}
			for(int i = 0; i < width; i++) {
				result.add(matrix[start+length-1][start+width-i-1]);
			}
			for(int i = 1; i < length-1; i++) {
				result.add(matrix[start+length-1-i][start]);
			}
			length -= 2;
			width -= 2;
			start++;
		}
		if(length == 1) {
			for(int i = 0; i < width; i++) {
				result.add(matrix[start][start+i]);
			}
		}
		else if(width == 1) {
			for(int i = 0; i < length; i++) {
				result.add(matrix[start+i][start]);
			}
		}
		return result;
	}
}
