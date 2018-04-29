class Solution {
	public int uniquePathsWithObstacles(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int[][] extended = new int[length+1][width+1];
		extended[0][1] = 1;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				extended[i+1][j+1] = (grid[i][j] == 1) ? 0 : extended[i+1][j] + extended[i][j+1];
			}
		}
		return extended[length][width];
	}
}
