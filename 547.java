class Solution {
	public int findCircleNum(int[][] M) {
		boolean[] been = new boolean[M.length];
		int count = 0;
		for(int i = 0; i < M.length; i++) {
			if(!been[i]) {
				dfs(M, been, i);
				count++;
			}
		}
		return count;
	}
	private void dfs(int[][] M, boolean[] been, int now) {
		been[now] = true;
		for(int next = 0; next < M.length; next++) {
			if(!been[next] && M[now][next] == 1) {
				dfs(M, been, next);
			}
		}
	}
}
