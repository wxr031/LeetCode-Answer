class Solution {
	public boolean find132pattern(int[] nums) {
		if(nums.length < 3) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int mid = Integer.MIN_VALUE;
		for(int i = nums.length - 1; i >= 0; i--) {
			if(nums[i] < mid) {
				return true;
			}
			else {
				while(!stack.isEmpty() && nums[i] > stack.peek()) {
					mid = stack.pop();
				}
				stack.push(nums[i]);
			}
		}
		return false;
	}
}