class Solution {
	public int[][] updateMatrix(int[][] matrix) {
		Queue<int[]> queue = new LinkedList<>();
		int row = matrix.length, col = matrix[0].length;
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(matrix[r][c] == 0)
					queue.offer(new int[] {r, c});
				else
					matrix[r][c] = Integer.MAX_VALUE;
			}
		}
		int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		while(!queue.isEmpty()) {
			int[] coord = queue.poll();
			int ro = coord[0], co = coord[1];
			for(int[] dir : direction) {
				int rn = ro + dir[0], cn = co + dir[1];
				if(rn < 0 || rn >= row || cn < 0 || cn >= col)
					continue;
				if(matrix[ro][co] + 1 < matrix[rn][cn]) {
					matrix[rn][cn] = matrix[ro][co] + 1;
					queue.offer(new int[] {rn, cn});
				}
			}
		}
		return matrix;
	}
}

