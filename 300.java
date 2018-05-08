class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] array = new int[nums.length+1];
		int length = 0;
		array[0] = Integer.MIN_VALUE;
		for(int num : nums) {
			if(num > array[length]) {
				array[++length] = num;
			}
			else {
				int left = 0, right = length;
				while(left + 1 < right) {
					int mid = left + (right - left) / 2;
					if(array[mid] < num) {
						left = mid;
					}
					else {
						right = mid;
					}
				}
				array[right] = num;
			}
		}
		return length;
	}
}
