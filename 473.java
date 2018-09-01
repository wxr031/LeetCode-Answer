class Solution {
	public boolean makesquare(int[] nums) {
		if (nums.length < 4) {
			return false;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 4 != 0) {
			return false;
		}

		/* sort array in reverse order */
		Arrays.sort(nums);
		for(int i = 0, j = nums.length - 1; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		return dfs(nums, new int[4], 0, sum >> 2);
	}

	private boolean dfs(int[] nums, int[] sums, int curr, int side) {
		if (curr == nums.length) {
			return sums[0] == side && sums[1] == side && sums[2] == side;
		}
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[curr] <= side) {
				sums[i] += nums[curr];
				if (dfs(nums, sums, curr + 1, side)) {
					return true;
				}
				sums[i] -= nums[curr];
			}
		}
		return false;
	}
}
