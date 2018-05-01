class Solution {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int front = 0, back = 0;
		while(back < nums.length) {
			int prev = back;
			while(back < nums.length && nums[back] == nums[prev]) {
				back++;
			}
			if(back - prev >= 2) {
				nums[front] = nums[front+1] = nums[prev];
				front += 2;
			}
			else {
				nums[front] = nums[prev];
				front++;
			}
		}
		return front;
	}
}

