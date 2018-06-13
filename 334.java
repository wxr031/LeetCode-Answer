class Solution {
	public boolean increasingTriplet(int[] nums) {
		int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
		for(int num : nums) {
			if(num <= mid1) {
				mid1 = num;
			}
			else if(num <= mid2) {
				mid2 = num;
			}
			else return true;
		}
		return false;
	}
}
