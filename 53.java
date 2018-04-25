class Solution {
	public int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE, curr = 0;
		for(int num : nums) {
			if(curr + num >= 0) curr += num;
			else curr = num;
			result = Math.max(curr, result);
            if(curr < 0) curr = 0;
		}
		return result;
	}
}
