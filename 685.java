class Solution {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i <= edges.length; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int[] indegree = new int[edges.length + 1];
		for(int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			indegree[edge[1]]++;
		}
		int deg0 = -1, deg2 = -1;
		for(int i = 1; i <= edges.length; i++) {
			if(indegree[i] == 0) {
				deg0 = i;
			}
			else if(indegree[i] == 2) {
				deg2 = i;
			}
		}
		boolean[] been = new boolean[edges.length + 1];
		if(deg0 != -1) {
			boolean another = false;
			for(int i = edges.length - 1; i >= 0; i--) {
				if(edges[i][1] == deg2) {
					if(another || cover(edges[i], deg0, adj, been) == edges.length) {
						return edges[i];
					}
					else {
						another = true;
					}
				}
			}
		}
		else {
			for(int i = edges.length - 1; i >= 0; i--) {
				if(!been[i] && loop(edges[i][0], edges[i][1], adj, been)) {
					return edges[i];
				}
			}
		}
		return null;
	}
	private int cover(int[] ignore, int now, List<List<Integer>> adj, boolean[] been) {
		been[now] = true;
		int count = 0;
		for(int next : adj.get(now)) {
			if(been[next] || (now == ignore[0] && next == ignore[1])) {
				continue;
			}
			count += cover(ignore, next, adj, been);
		}
		return count + 1;
	}
	private boolean loop(int last, int now, List<List<Integer>> adj, boolean[] been) {
		been[now] = true;
		for(int next : adj.get(now)) {
			if(been[next]) {
				continue;
			}
			if(next == last || loop(last, next, adj, been)) {
				return true;
			}
		}
		return false;
	}
}
