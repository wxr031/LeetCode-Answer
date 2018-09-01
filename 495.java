class Solution {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if(timeSeries.length == 0) return 0;
		int prev = 0, total = 0;
		for(int curr = 1; curr < timeSeries.length; curr++) {
			if(timeSeries[curr] > timeSeries[curr - 1] + duration) {
				total += timeSeries[curr - 1] - timeSeries[prev] + duration;
				prev = curr;
			}
		}
		return total + timeSeries[timeSeries.length - 1] - timeSeries[prev] + duration;
	}
}
