class MedianFinder {

	/** initialize your data structure here. */
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public MedianFinder() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap.offer(Integer.MAX_VALUE);
		maxHeap.offer(Integer.MIN_VALUE);
	}

	public void addNum(int num) {
		if(minHeap.size() == maxHeap.size()) {
			if(num > maxHeap.peek()) {
				minHeap.offer(num);
			} else {
				maxHeap.offer(num);
			}
		} else if(minHeap.size() > maxHeap.size()) {
			if(num > maxHeap.peek()) {
				minHeap.offer(num);
				maxHeap.offer(minHeap.poll());
			} else {
				maxHeap.offer(num);
			}
		} else {
			if(num > maxHeap.peek()) {
				minHeap.offer(num);
			} else {
				maxHeap.offer(num);
				minHeap.offer(maxHeap.poll());
			}
		}
	}

	public double findMedian() {
		if(maxHeap.size() > minHeap.size())
			return (double) maxHeap.peek();
		if(maxHeap.size() < minHeap.size())
			return (double) minHeap.peek();
		return (double)(maxHeap.peek() + minHeap.peek()) / 2;
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

