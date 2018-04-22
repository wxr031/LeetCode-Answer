class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		int arrayLength = nums.length;
		for(int i = 0; i < arrayLength; ++i) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No Solution");
	}
}
