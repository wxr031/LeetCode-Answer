class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permute(nums, nums.length, list);
		return list;
	}
	private void permute(int[] nums, int length, List<List<Integer>> result) {
		if (length == 1) {
			List<Integer> sub = new ArrayList<>();
			for (int num : nums) {
				sub.add(num);
			}
			result.add(sub);
			return;
		}
		for (int i = 0; i < length; i++) {
			if (length % 2 == 1) {
				swap(nums, 0, length - 1);
			}
			else {
				swap(nums, i, length - 1);
			}
			permute(nums, length - 1, result);
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
