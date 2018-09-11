class Solution {
	public int[] sumOfDistancesInTree(int num, int[][] edges) {
		int[] sum = new int[num], childNum = new int[num];
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		dfs1(graph, new boolean[num], childNum, sum, 0, 0);
		dfs2(graph, new boolean[num], childNum, sum, num, 0);
		return sum;
	}
	private void dfs1(List<List<Integer>> graph, boolean[] been, int[] childNum, int[] sum, int layer, int now) {
		been[now] = true;
		sum[0] += layer;
		for(int next : graph.get(now)) {
			if(!been[next]) {
				dfs1(graph, been, childNum, sum, layer + 1, next);
				childNum[now] += childNum[next] + 1;
			}
		}
	}
	private void dfs2(List<List<Integer>> graph, boolean[] been, int[] childNum, int[] sum, int num, int now) {
		been[now] = true;
		for(int next : graph.get(now)) {
			if(!been[next]) {
				sum[next] = sum[now] + num - childNum[next] * 2 - 2;
				dfs2(graph, been, childNum, sum, num, next);
			}
		}
	}
}
