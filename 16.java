class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			int search = target - nums[i];
			while(left < right) {
				int sum = nums[left] + nums[right], diff;
				if(sum == search) {
					return target;
				}
				if((diff = Math.abs(sum - search)) < minDiff) {
					minDiff = diff;
					result = nums[i] + sum;
				}
				if(sum > search) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		return result;
	}
}
