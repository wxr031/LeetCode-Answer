class Solution {
	public static int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int left = -1, right = 1000001;
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if(k <= distanceSuffix(nums, mid)) right = mid;
			else left = mid;
		}
		return right;
	}
	private static int distanceSuffix(int[] nums, int dist) {
		int left = 0, right = 1, count = 0;
		while(left < nums.length - 1) {
			while(right < nums.length && nums[right] - nums[left] <= dist) right++;
			count += right - left - 1;
			left++;
		}
		return count;
	}
}
