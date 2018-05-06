class Solution {
	public int maxProduct(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		int max = Integer.MIN_VALUE;
		int curr = 1;
		for(int i = 0; i < nums.length; i++) {
			curr *= nums[i];
			max = Math.max(max, curr);
			if(nums[i] == 0) {
				curr = 1;
			}
		}
		curr = 1;
		for(int i = nums.length-1; i >= 0; i--) {
			curr *= nums[i];
			max = Math.max(max, curr);
			if(nums[i] == 0) {
				curr = 1;
			}
		}
		return max;
	}
}
