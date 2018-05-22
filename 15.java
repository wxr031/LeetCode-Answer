class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int prev = Integer.MIN_VALUE;
		for(int pos = 0; pos < nums.length-2; pos++) {
			if(prev != nums[pos]) {
				int target = -nums[pos];
				int left = pos+1, right = nums.length-1;
				while(left < right) {
					if(nums[left] + nums[right] < target) {
						left++;
					}
					else if(nums[left] + nums[right] > target) {
						right--;
					}
					else {
						result.add(Arrays.asList(nums[pos], nums[left], nums[right]));
						while(left < nums.length-1 && nums[left] == nums[left+1]) left++;
						while(right > 0 && nums[right] == nums[right-1]) right--;
						right--;
						left++;
					}
					prev = nums[pos];
				}
			}
		}
		return result;
	}
}
