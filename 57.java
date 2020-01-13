class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] intervalsMod = new int[intervals.length + 2][2];
		intervalsMod[0] = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
		for (int i = 0; i < intervals.length; i++) {
			intervalsMod[i + 1] = intervals[i];
		}
		intervalsMod[intervals.length + 1] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		int leftMargin, rightMargin, left, right;
		left = 0;
		right = intervalsMod.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (newInterval[0] > intervalsMod[mid][1]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		leftMargin = left;
		
		left = 0;
		right = intervalsMod.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (newInterval[1] >= intervalsMod[mid][0]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		rightMargin = right - 1;

		
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i < leftMargin; i++) {
			list.add(intervalsMod[i]);
		}
		list.add(new int[] {Math.min(intervalsMod[leftMargin][0], newInterval[0]), Math.max(intervalsMod[rightMargin][1], newInterval[1])});
		for (int i = rightMargin + 1; i < intervalsMod.length - 1; i++) {
			list.add(intervalsMod[i]);
		}
		int[][] result = new int[list.size()][2];
		result = list.toArray(result);
		return result;
	}
}
