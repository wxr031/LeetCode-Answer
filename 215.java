class Solution {
	public int findKthLargest(int[] nums, int k) {
		int pivotPos = getPivot(nums, k);
		if(pivotPos > nums.length-k) {
			return findKthLargest(Arrays.copyOfRange(nums, 0, pivotPos), k-nums.length+pivotPos);
		}
		else if (pivotPos < nums.length-k){
			return findKthLargest(Arrays.copyOfRange(nums, pivotPos+1, nums.length), k);
		}
		else {
			return nums[pivotPos];
		}
	}
	public int getPivot(int[] nums, int k) {
		// randomly choose a pivot
		int pivotPos = (int)(Math.random() * nums.length), pivot = nums[pivotPos];
		swap(nums, 0, pivotPos);

		// quick selection
		int lastPos = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] < pivot) {
				swap(nums, i, ++lastPos);
			}
		}
		swap(nums, 0, lastPos);
		return lastPos;
	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
