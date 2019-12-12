class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[0][0];
		}
		Arrays.sort(intervals, (interval1, interval2) -> {
			if (interval1[0] == interval2[0]) {
				return interval1[1] - interval2[1];
			}
			return interval1[0] - interval2[0];
		});
		List<int[]> list = new ArrayList<>();
		int[] prevInterval = intervals[0];
		for (int[] currInterval : intervals) {
			if (currInterval[0] > prevInterval[1]) {
				list.add(prevInterval);
				prevInterval = currInterval;
			}
			else if (currInterval[1] >= prevInterval[1]) {
				prevInterval[1] = currInterval[1];
			}
		}
		list.add(prevInterval);
		int[][] result = new int[list.size()][2];
		return list.toArray(result);
	}
}
