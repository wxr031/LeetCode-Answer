class Solution {
	public double[] medianSlidingWindow(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		double[] median = new double[nums.length - k + 1];
		for(int i = 0; i < nums.length; i++) {
			if(maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
				maxHeap.offer(nums[i]);
			else
				minHeap.offer(nums[i]);
			balance(maxHeap, minHeap);
			if(i >= k - 1) {
				if((k & 1) == 0)
					median[i - k + 1] = ((double)minHeap.peek() + maxHeap.peek()) / 2.0;
				else
					median[i - k + 1] = (double)maxHeap.peek();
				if(nums[i - k + 1] <= median[i - k + 1])
					maxHeap.remove(nums[i - k + 1]);
				else
					minHeap.remove(nums[i - k + 1]);
				balance(maxHeap, minHeap);
			}

		}
		return median;
	}
    private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.size() == minHeap.size() + 2)
			minHeap.offer(maxHeap.poll());
		else if(maxHeap.size() + 1 == minHeap.size())
			maxHeap.offer(minHeap.poll());
    }
}
