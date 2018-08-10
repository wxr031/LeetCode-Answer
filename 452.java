class Solution {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, (point1, point2) -> point1[1] - point2[1]);
		int lastEnd = points[0][1], shot = 1;
		for (int[] point : points) {
			if (lastEnd < point[0]) {
				shot++;
				lastEnd = point[1];
			}
		}
		return shot;
	}
}
