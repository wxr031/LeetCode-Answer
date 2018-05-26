class Solution {
	public void gameOfLife(int[][] board) {
		int row = board.length, col = board[0].length;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int count = 0;
				for(int r = Math.max(0, i-1); r <= Math.min(i+1, row-1); r++) {
					for(int c = Math.max(0, j-1); c <= Math.min(j+1, col-1); c++) {
						if((r != i || c != j) && (board[r][c] & 1) > 0) {
							count++;
						}
					}
				}
				if(((board[i][j] == 1) && ((count & 2) > 0 && (count & 4) == 0))
						|| (board[i][j] == 0 && count == 3)) {
					board[i][j] |= 2;
				}
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] >>= 1;
			}
		}
	}
}

