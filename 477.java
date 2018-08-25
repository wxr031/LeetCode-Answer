class Solution {
	public int totalHammingDistance(int[] nums) {
		int count = 0;
		for(int i = 0; i < 32; i++) {
			int one = 0;
			for(int num : nums) {
				one += ((num >> i) & 1);
			}
			count += one * (nums.length - one);
		}
		return count;
	}
}
