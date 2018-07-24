class Solution {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<>();
		}
		List<int[]> result = new ArrayList<>();
		boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
		boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			if(!pacific[i][0]) {
				dfs(pacific, matrix, i, 0);
			}
			if(!atlantic[i][matrix[0].length - 1]) {
				dfs(atlantic, matrix, i, matrix[0].length - 1);
			}
		}
		for(int j = 0; j < matrix[0].length; j++) {
			if(!pacific[0][j]) {
				dfs(pacific, matrix, 0, j);
			}
			if(!atlantic[matrix.length - 1][j]) {
				dfs(atlantic, matrix, matrix.length - 1, j);
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(pacific[i][j] && atlantic[i][j]) {
					result.add(new int[] {i, j});
				}
			}
		}
		return result;
	}
	private void dfs(boolean[][] ocean, int[][] matrix, int i, int j) {
		ocean[i][j] = true;
		if(i < matrix.length - 1 && !ocean[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) {
			dfs(ocean, matrix, i + 1, j);
		}
		if(i > 0 && !ocean[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) {
			dfs(ocean, matrix, i - 1, j);
		}
		if(j < matrix[0].length - 1 && !ocean[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) {
			dfs(ocean, matrix, i, j + 1);
		}
		if(j > 0 && !ocean[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) {
			dfs(ocean, matrix, i, j - 1);
		}
	}
}
