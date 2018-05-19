ass Solution {
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = 0;
		int[] heights = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == '0') heights[j] = 0;
				else heights[j]++;
			}
			result = Math.max(result, largestRectangleArea(heights));
		}
		return result;
	}
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i <= heights.length; i++) {
			int height = (i == heights.length) ? 0 : heights[i];
			while(!stack.isEmpty() && height < heights[stack.peek()]) {
				int barHeight = heights[stack.pop()];
				int area = (i - ((stack.isEmpty()) ? -1 : stack.peek()) - 1) * barHeight;
				result = Math.max(area, result);
			}
			stack.push(i);
		}
		return result;
	}
}

