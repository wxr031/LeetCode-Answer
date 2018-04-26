class Solution {
	public boolean canJump(int[] nums) {
		int farthest = 0;
		for(int i = nums.length-1; i >= 0; i--) {
			if(i + nums[i] >= farthest) {
				farthest = i;
			}
		}
		return farthest == 0;
	}
}

