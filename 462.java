class Solution {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int moves = 0;
		for(int i = 0, j = nums.length - 1; i < j; i++, j--) {
			moves += nums[j] - nums[i];
		}
		return moves;
	}
}
