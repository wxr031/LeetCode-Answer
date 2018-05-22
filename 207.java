class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int[] edge : prerequisites) {
			adj.get(edge[0]).add(edge[1]);
		}
		byte[] visited = new byte[numCourses];
		for(int i = 0; i < numCourses; i++) {
			if(visited[i] == 0 && !dfs(adj, visited, i)) {
				return false;
			}
		}
		return true;
	}
	public boolean dfs(List<List<Integer>> adj, byte[] visited, int id) {
		visited[id] = 1;
		for(int v : adj.get(id)) {
			if(visited[v] == 1 || (visited[v] == 0 && !dfs(adj, visited, v))) {
				return false;
			}
		}
		visited[id] = -1;
		return true;
	}
}
