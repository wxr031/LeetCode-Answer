class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList()));
		Arrays.sort(nums);
		int last = 0;
		for(int i = 0; i < nums.length; i++) {
			int begin = (i == 0 || (nums[i] == nums[i-1])) ? last : 0;
			last = result.size();
			for(int j = begin; j < last; j++) {
				List<Integer> build = new ArrayList<Integer>(result.get(j));
				build.add(nums[i]);
				result.add(build);
			}
		}
		return result;
	}
}
