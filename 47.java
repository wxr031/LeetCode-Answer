class Solution {
	public static void permuteUniqueUtil(int[] nums, boolean[] used, int remain,
			List<List<Integer>> result, List<Integer> temp) {
		if(remain == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int curr = 0; curr < nums.length; curr++) {
			if(!used[curr]) {
				used[curr] = true;
				temp.add(nums[curr]);
				permuteUniqueUtil(nums, used, remain-1, result, temp);
				temp.remove(temp.size()-1);
				used[curr] = false;
				while(curr < nums.length-1 && nums[curr] == nums[curr+1]) {
					curr++;
				}
			}
		}
	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		permuteUniqueUtil(nums, used, nums.length, result, temp);
		return result;
	}
}
