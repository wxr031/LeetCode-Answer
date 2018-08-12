class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[][] minDist = new int[2][n];
		byte par = 0;
		Arrays.fill(minDist[0], Integer.MAX_VALUE);
		Arrays.fill(minDist[1], Integer.MAX_VALUE);
		minDist[0][src] = minDist[1][src] = 0;
		while(k-- >= 0) {
			for(int[] flight : flights) {
				if(minDist[par][flight[0]] != Integer.MAX_VALUE
						&& minDist[par][flight[0]] + flight[2] < minDist[par ^ 1][flight[1]]) {
					minDist[par ^ 1][flight[1]] = minDist[par][flight[0]] + flight[2];
				}
			}
			par ^= 1;
		}
		return minDist[par][dst] != Integer.MAX_VALUE ? minDist[par][dst] : -1;
	}
}
