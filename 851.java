class Solution {
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		int num = quiet.length;
		boolean[] indegreeGt0 = new boolean[num];
		int[] result = new int[num];
		List<List<Integer>> adj = new ArrayList<>();
		Arrays.fill(result, -1);
		for(int i = 0; i < num; i++) {
			adj.add(i, new ArrayList<>());
		}
		for(int[] rich : richer) {
			adj.get(rich[1]).add(rich[0]);
			indegreeGt0[rich[0]] = true;
		}
		for(int i = 0; i < num; i++) {
			if(!indegreeGt0[i]) {
				dfs(adj, quiet, result, i);
			}
		}
		return result;
	}
	int dfs(List<List<Integer>> adj, int[] quiet, int[] result, int curr) {
		if(result[curr] != -1)
			return result[curr];
		result[curr] = curr;
		for(int next : adj.get(curr)) {
			int minQuiet = dfs(adj, quiet, result, next);
			if(quiet[minQuiet] < quiet[result[curr]]) {
				result[curr] = minQuiet;
			}
		}
		return result[curr];
	}
}
