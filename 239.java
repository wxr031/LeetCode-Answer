class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		return result;
	}
}
