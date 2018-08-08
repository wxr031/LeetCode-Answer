class Solution {
	public int numberOfBoomerangs(int[][] points) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int m = 0; m < points.length; m++) {
			for(int n = 0; n < points.length; n++) {
				if(n != m) {
					int dx = points[m][0] - points[n][0], dy = points[m][1] - points[n][1];
					int dist = dx * dx + dy * dy;
					int num = map.getOrDefault(dist, 0);
					count += num;
					map.put(dist, num + 1);
				}
			}
			map.clear();
		}
		return count << 1;
	}
}
