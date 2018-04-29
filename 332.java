class Solution {
	public List<String> findItinerary(String[][] tickets) {
		Map<String,PriorityQueue<String>> adj = new HashMap<>();
		for(String[] ticket : tickets) {
			adj.putIfAbsent(ticket[0], new PriorityQueue<String>());
			adj.get(ticket[0]).add(ticket[1]);
		}
		List<String> result = new ArrayList<>();
		dfs(result, adj, "JFK");
		return result;
	}
	public void dfs(List<String> result, Map<String,PriorityQueue<String>> adj, String now) {
		if(adj.containsKey(now)) {
			while(!adj.get(now).isEmpty()) {
				dfs(result, adj, adj.get(now).poll());
			}
		}
		result.add(0, now);
	}
}

