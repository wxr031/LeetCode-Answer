class Solution {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		findSubsequencesUtil(new ArrayList<Integer>(), set, nums, -1);
		return new ArrayList<List<Integer>>(set);
	}
	private void findSubsequencesUtil(List<Integer> temp, Set<List<Integer>> set, int[] nums, int now) {
		for(int i = now + 1; i < nums.length; i++) {
			if(temp.size() == 0 || nums[i] >= nums[now]) {
				temp.add(nums[i]);
				findSubsequencesUtil(temp, set, nums, i);
				temp.remove(temp.size() - 1);
			}
		}
		if(temp.size() > 1) {
			set.add(new ArrayList<Integer>(temp));
		}
	}
}
