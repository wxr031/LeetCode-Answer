class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) return Collections.singletonList(0);
		List<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int[] indegree = new int[n];
		for(int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
			indegree[edge[0]]++;
			indegree[edge[1]]++;
		}
		List<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(indegree[i] == 1) {
				queue.add(i);
			}
		}
		while(n > 2) {
			n -= queue.size();
			List<Integer> newQueue = new LinkedList<>();
			for(int source : queue) {
				for(int dest : adj.get(source)) {
					if(--indegree[dest] == 1) {
						newQueue.add(dest);
					}
				}
			}
			queue = newQueue;
		}
		return queue;
	}
}

