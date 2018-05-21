class Solution {
	public int numIslands(char[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int length = grid.length, width = grid[0].length;
		int result = 0;
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < width; c++) {
				if (grid[r][c] == '1') {
					result++;
					dfs(grid, length, width, r, c);
				}
			}
		}
		return result;
	}

	private void dfs(char[][] grid, int length, int width, int r, int c) {
		if (r < 0 || r >= length || c < 0 || c >= width || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		dfs(grid, length, width, r+1, c);
		dfs(grid, length, width, r-1, c);
		dfs(grid, length, width, r, c+1);
		dfs(grid, length, width, r, c-1);
	}
}
