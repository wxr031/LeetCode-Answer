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
	private boolean cutLess(int[] nums, int minCut, int sumMin) {
		int sum = 0, allCut = 0;
		for(int num : nums) {
			sum += num;
			if(sum > sumMin) {
				allCut++;
				sum = num;
			}
			if(allCut > minCut) return false;
		}
		return true;
	}
}
