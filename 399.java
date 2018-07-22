class Solution {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, ArrayList<String>> adj = new HashMap<>();
		HashMap<String, ArrayList<Double>> val = new HashMap<>();
		HashSet<String> exist = new HashSet<>();
		/* construct graph */
		for(int i = 0; i < equations.length; i++) {
			for(int j = 0; j <= 1; j++) {
				adj.putIfAbsent(equations[i][j], new ArrayList<String>());
				val.putIfAbsent(equations[i][j], new ArrayList<Double>());
				adj.get(equations[i][j]).add(equations[i][j ^ 1]);
				val.get(equations[i][j]).add((j == 0) ? values[i] : 1.0 / values[i]);
				exist.add(equations[i][j]);
			}
		}
		/* do depth first search on every query */
		double[] result = new double[queries.length];
		double temp;
		for(int i = 0; i < queries.length; i++) {
			if(!exist.contains(queries[i][0]) || !exist.contains(queries[i][1])) {
				result[i] = -1.0;
			}
			else {
				result[i] = dfs(adj, val, new HashSet<String>(), queries[i][0], queries[i][1], 1.0);
			}
		}
		return result;
	}
	private double dfs(HashMap<String, ArrayList<String>> adj,
			HashMap<String, ArrayList<Double>> val,
			HashSet<String> been, String start, String end, double product) {
		if(start.equals(end)) {
			return product;
		}
		been.add(start);
		ArrayList<String> adjMap = adj.get(start);
		ArrayList<Double> valMap = val.get(start);
		double temp;
		for(int i = 0; i < adjMap.size(); i++) {
			if(!been.contains(adjMap.get(i)) &&
					(temp = dfs(adj, val, been, adjMap.get(i), end, product * valMap.get(i))) != -1.0) {
				return temp;
			}
		}
		return -1.0;
	}
}
