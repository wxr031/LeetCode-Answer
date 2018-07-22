class Solution {

	int[] array;
	Random random = new Random();

	public Solution(int[] nums) {
		array = nums;
	}

	public int pick(int target) {
		int result = -1, count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == target && random.nextInt(++count) == 0) {
				result = i;
			}
		}
		return result;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
