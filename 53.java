class Solution {
	public static int maxSubArray(int[] nums) {
		boolean allNeg = true;
		int maxNeg = Integer.MIN_VALUE;
		for(int num : nums) {
			if(num > 0) {
				allNeg = false;
				break;
			}
			maxNeg = Math.max(num, maxNeg);
		}
		if(allNeg) return maxNeg;

		int result = 0, curr = 0;
		for(int num : nums) {
			if(curr + num >= 0) curr += num;
			else curr = 0;
			result = Math.max(curr, result);
		}
		return result;
	}
	public static void main(String args[]) {
		int[] nums = new int[] {-3, -7, -1, 3, -2, -3};
		System.out.println(maxSubArray(nums));
	}
}
