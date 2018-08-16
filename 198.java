class Solution {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int rob = 0, nrob = 0;
		for(int num : nums) {
			int temp = nrob;
			nrob = Math.max(nrob, rob);
			rob = temp + num;
		}
		return Math.max(rob, nrob);
	}
}
