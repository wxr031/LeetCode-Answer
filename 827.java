import java.util.*;
class Solution {
    public int largestIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, column = grid[0].length;
		int[][] gridExt = new int[row + 1][column + 1];
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= row; j++) {
				gridExt[i][j] = grid[i - 1][j - 1];
			}
		}
        boolean[][] been = new boolean[row][column];
        int[] size = new int[row * column];
        int island = 0;
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= row; j++) {
                if(!been[i][j] && grid[i][j] == 1)
                    dfs(gridExt, been, size, i, j, ++island);
            }
        }
        if(island <= 1) return size[island] + (size[1] == row * column ? 0 : 1);
		int result = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(gridExt[i][j] == 0) {
					// do sth here
				}
			}
		}
		return result;
    }
    private void dfs(int[][] gridExt, boolean[][] been, int[] size, int i, int j, int island) {
        been[i][j] = true;
        gridExt[i][j] = island;
        size[island]++;
        if(gridExt[i + 1][j] == 1 && !been[i + 1][j])
			dfs(gridExt, been, size, i + 1, j, island);
        if(gridExt[i - 1][j] == 1 && !been[i - 1][j])
			dfs(gridExt, been, size, i - 1, j, island);
        if(gridExt[i][j + 1] == 1 && !been[i][j + 1])
			dfs(gridExt, been, size, i, j + 1, island);
        if(gridExt[i][j - 1] == 1 && !been[i][j - 1])
			dfs(gridExt, been, size, i, j - 1, island);
    }
}
