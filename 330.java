class Solution {
	public int minPatches(int[] nums, int n) {
		long lack = 1;
		int id = 0, result = 0;
		while(lack <= n) {
			if(id == nums.length || lack < nums[id]) {
				lack <<= 1;
				result++;
			}
			else {
				lack += nums[id++];
			}
		}
		return result;
	}
}
