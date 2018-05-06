class Solution {
	public int robLine(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int rob = 0, nrob = 0;
		for(int num : nums) {
			int robTemp = rob;
			rob = Math.max(rob, nrob + num);
			nrob = robTemp;
		}
		return Math.max(rob, nrob);
	}
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		return Math.max(nums[0] + robLine(Arrays.copyOfRange(nums, 2, nums.length-1)),
				robLine(Arrays.copyOfRange(nums, 1, nums.length)));
	}
}
