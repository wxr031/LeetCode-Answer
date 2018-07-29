class Solution {
	public void nextPermutation(int[] nums) {
		if(nums.length == 0) return;
		int pos = nums.length - 2;
		while(pos >= 0 && nums[pos] >= nums[pos+1]) {
			pos--;
		}
		if(pos != -1) {
			int swapPos = pos;
			while(swapPos < nums.length-1 && nums[swapPos+1] > nums[pos]) {
				swapPos++;
			}
			swap(nums, pos, swapPos);
		}
		/* reverse */
		for(int i = pos + 1, j = nums.length - 1; i < j; i++, j--) {
			swap(nums, i, j);
		}
	}
	private void swap(int[] nums, int pos, int swapPos) {
		int temp = nums[pos];
		nums[pos] = nums[swapPos];
		nums[swapPos] = temp;
	}
}
