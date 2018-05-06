class Solution {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int rob = 0, nrob = 0;
		for(int num : nums) {
			int robTemp = rob;
			rob = Math.max(rob, nrob + num);
			nrob = robTemp;
		}
		return Math.max(rob, nrob);
	}
}
