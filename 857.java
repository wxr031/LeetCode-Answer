class Solution {
	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		double[][] ratio = new double[quality.length][2];
		for(int i = 0; i < quality.length; i++) {
			ratio[i] = new double[] {(double)wage[i] / quality[i], quality[i]};
		}
		Arrays.sort(ratio, (ratio1, ratio2) -> Double.compare(ratio1[0], ratio2[0]));
		PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
		int currSum = 0;
		double result = Double.MAX_VALUE;
		for(int i = 0; i < quality.length; i++) {
			if(pq.size() == k) {
				result = Math.min(ratio[i - 1][0] * currSum, result);
				currSum -= pq.poll();
			}
			pq.offer(ratio[i][1]);
			currSum += ratio[i][1];
		}
		result = Math.min(ratio[quality.length - 1][0] * currSum, result);
		return result;
	}
}
