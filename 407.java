class Solution {
	public static class Point implements Comparable<Point>{
		int r, c, val;
		Point(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
		@Override
			public int compareTo(Point p1) {
				return this.val - p1.val;
			}
	}
	public static int trapRainWater(int[][] heightMap) {
		if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
			return 0;
		int row = heightMap.length, col = heightMap[0].length;
		int maxHeight = Integer.MIN_VALUE, total = 0;
		boolean[][] visited = new boolean[row][col];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for(int r = 0; r < row; r++) {
			pq.offer(new Point(r, 0, heightMap[r][0]));
			pq.offer(new Point(r, col - 1, heightMap[r][col - 1]));
			visited[r][0] = visited[r][col - 1] = true;
		}
		for(int c = 1; c < col - 1; c++) {
			pq.offer(new Point(0, c, heightMap[0][c]));
			pq.offer(new Point(row - 1, c, heightMap[row - 1][c]));
			visited[0][c] = visited[row - 1][c] = true;
		}
		while(!pq.isEmpty) {
			Point point = pq.poll();
			int r = point.r, c = point.c;
			if(heightMap[r][c] < maxHeight)
				total += maxHeight - heightMap[r][c];
			else maxHeight = heightMap[r][c];
			if(r > 0 && !visited[r - 1][c]) {
				pq.offer(new Point(r - 1, c, heightMap[r - 1][c]));
				visited[r - 1][c] = true;
			}
			if(r < row - 1 && !visited[r + 1][c]) {
				pq.offer(new Point(r + 1, c, heightMap[r + 1][c]));
				visited[r + 1][c] = true;
			}
			if(c > 0 && !visited[r][c - 1]) {
				pq.offer(new Point(r, c - 1, heightMap[r][c - 1]));
				visited[r][c - 1] = true;
			}
			if(c < col - 1 && !visited[r][c + 1]) {
				pq.offer(new Point(r, c + 1, heightMap[r][c + 1]));
				visited[r][c + 1] = true;
			}
		}
		return total;
	}
}
