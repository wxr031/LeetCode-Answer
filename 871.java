class Solution {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int times = 0, dist = 0, now = 0;
		while(startFuel < target) {
			while(now < stations.length && stations[now][0] <= startFuel) {
				pq.offer(stations[now++][1]);
			}
			if(pq.isEmpty()) {
				return -1;
			}
			startFuel += pq.poll();
			times++;
		}
		return times;
	}
}

