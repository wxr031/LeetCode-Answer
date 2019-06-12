class Solution {
	public int jump(int[] nums) {
		int farthest = 0, rightMost = 0, times = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == rightMost) {
				times++;
				rightMost = farthest;
			}
		}
		return times;
	}
}
