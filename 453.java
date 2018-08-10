class Solution {
	public int minMoves(int[] nums) {
		int minValue = Integer.MAX_VALUE, total = 0;
		for(int num : nums) {
			total += num;
			minValue = Math.min(minValue, num);
		}
		return total - nums.length * minValue;
	}
}
