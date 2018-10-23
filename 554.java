ass Solution {
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0, most;
		for(List<Integer> row : wall) {
			int totalGap = 0;
			for(int i = 0; i < row.size() - 1; i++) {
				totalGap += row.get(i);
				most = map.getOrDefault(totalGap, 0) + 1;
				map.put(totalGap, most);
				result = Math.max(result, most);
			}
		}
		return wall.size() - result;
	}
}
