class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0, right = 0;
		int sum = 0, result = Integer.MAX_VALUE;
		while(right < nums.length) {
			sum += nums[right++];
			if(sum >= s) {
				while(left < right && sum >= s) {
					sum -= nums[left++];
				}   
				result = Math.min(result, right - left + 1); 
			}   
		}   
		return left == 0 && right == nums.length ? 0 : result;
	}     
}
