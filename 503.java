class Solution {
	public int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[nums.length];
		for(int i = 2 * nums.length - 1; i >= 0; i--) {
			while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}
			if(i < nums.length) {
				result[i] = (stack.isEmpty() ? -1 : nums[stack.peek()]);
			}
			stack.push(i % nums.length);
		}
		return result;
	}
}
