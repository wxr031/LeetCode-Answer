class Solution {
	public int splitArray(int[] nums, int m) {
		int left = Integer.MIN_VALUE, right = 0;
		for(int num : nums) {
			left = Math.max(left, num);
			right += num;
		}
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(cutLess(nums, m - 1, mid)) right = mid;
			else left = mid + 1;
		}
		return left;
	}
	private boolean cutLess(int[] nums, int cutMin, int sumMin) {
		int sum = 0, cutAll = 0;
		for(int num : nums) {
			sum += num;
			if(sum > sumMin) {
				cutAll++;
				sum = num;
			}
			if(cutAll > cutMin) return false;
		}
		return true;
	}
}
