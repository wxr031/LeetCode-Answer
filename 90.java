class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		return subsetUtil(result, nums, pos);
	}
	public void subsetUtil(List<List<Integer>> result, List<Integer> temp, int[] nums, int pos) {
		if(pos == nums.length) {
			
		}
		result.add(nums[pos])
		subsetUtil(result, nums, pos+1);

	}
}
