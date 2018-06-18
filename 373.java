class Solution {
	private static class Compare implements Comparator<int[]> {
		int[] nums0, nums1;
		Compare(int[] nums0, int[] nums1) {
			this.nums0 = nums0;
			this.nums1 = nums1;
		}
		@Override
			public int compare(int[] pair1, int[] pair2) {
				return nums0[pair1[0]] + nums1[pair1[1]] > nums0[pair2[0]] + nums1[pair2[1]] ? 1 : -1;
			}
	}
	public List<int[]> kSmallestPairs(int[] nums0, int[] nums1, int k) {
		if(nums0.length == 0 || nums1.length == 0) return new ArrayList<int[]>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Compare(nums0, nums1));
		pq.offer(new int[] {0, 0});
		List<int[]> result = new ArrayList<>();
		boolean[][] put = new boolean[nums0.length][nums1.length];
		put[0][0] = true;
		while(k-- > 0 && !pq.isEmpty()) {
			int[] pair = pq.poll();
			if(pair[0] < nums0.length - 1 && !put[pair[0] + 1][pair[1]]) {
				pq.offer(new int[] {pair[0] + 1, pair[1]});
				put[pair[0] + 1][pair[1]] = true;
			}
			if(pair[1] < nums1.length - 1 && !put[pair[0]][pair[1] + 1]) {
				pq.offer(new int[] {pair[0], pair[1] + 1});
				put[pair[0]][pair[1] + 1] = true;
			}
			result.add(new int[] {nums0[pair[0]], nums1[pair[1]]});
		}
		return result;
	}
}
