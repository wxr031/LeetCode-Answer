class Solution {
	public int shortestPathLength(int[][] graph) {
		if(graph.length == 0 || graph[0].length == 0) return 0;
		int flag = 1 << graph.length;
		int[][] dp = new int[graph.length][flag];
		for(int i = 0; i < graph.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][0] = -1;
		}
		for(int r = 0; r <= graph.length; r++) {
			for(int i = 0; i < graph.length; i++) {
				for(int j : graph[i]) {
					for(int k = 0; k < flag; k++) {
						if(dp[i][k] != Integer.MAX_VALUE) {
							dp[j][k | (1 << i)] = Math.min(dp[j][k | (1 << i)], dp[i][k] + 1);
						}	
					}
				}
			}
		}
		int path = Integer.MAX_VALUE;
		for(int i = 0; i < graph.length; i++) {
			path = Math.min(path, dp[i][flag - 1]);
		}
		return path;
	}
}
