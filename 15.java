class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			if(i == 0 || nums[i] != nums[i - 1]) {
				int left = i + 1, right = nums.length - 1;
				while(left < right) {
					if(nums[left] + nums[right] > -nums[i]) {
						right--;
					}
					else if(nums[left] + nums[right] < -nums[i]) {
						left++;
					}
					else {
						result.add(Arrays.asList(nums[i], nums[left], nums[right]));
						while(left < nums.length - 1 && nums[left] == nums[left + 1]) {
							left++;
						}
						while(right > 0 && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
						right--;
					}
				}
			}
		}
		return result;
	}
}
