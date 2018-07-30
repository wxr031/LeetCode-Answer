class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums.length < 4) return new ArrayList<>();
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int[] twoSelect = new int[2];
		findKSum(nums, target, 4, 0, result, twoSelect);
		return result;
	}
	public void findKSum(int[] nums, int target, int k, int begin, List<List<Integer>> result, int[] twoSelect) {
		if(begin == nums.length) {
			return;   
		}
		if(k == 2) {
			int end = nums.length - 1;
			while(begin < end) {
				if(nums[begin] + nums[end] < target) {
					begin++;
				}
				else if(nums[begin] + nums[end] > target) {
					end--;
				}
				else {
					result.add(Arrays.asList(twoSelect[1], twoSelect[0], nums[begin], nums[end]));
					while(begin < nums.length - 1 && nums[begin] == nums[begin + 1]) {
						begin++;
					}
					while(end > 0 && nums[end] == nums[end - 1]) {
						end--;
					}
					begin++;
					end--;
				}
			}
			return;
		}
		while(begin < nums.length) {
			twoSelect[k - 3] = nums[begin];
			findKSum(nums, target - nums[begin], k - 1, begin + 1, result, twoSelect);
			while(begin < nums.length - 1 && nums[begin] == nums[begin + 1]) {
				begin++;
			}
			begin++;
		}
	}
}
