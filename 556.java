ass Solution {
	public int nextGreaterElement(int num) {
		if(num == 0) return 0;
		int[] nums = new int[10];
		int top = 0, temp = num;
		while(temp > 0) {
			nums[top++] = temp % 10;
			temp /= 10;
		}
		int beg = 0;
		do ++beg; while(beg < top && nums[beg] >= nums[beg - 1]);
		if(beg == top) return -1;
		int end = -1;
		do ++end; while(end < beg && nums[end] <= nums[beg]);
		swap(nums, beg, end);
		end = 0;
		while(end < beg) swap(nums, end++, --beg);
		long result = 0;
		for(int i = top - 1; i >= 0; i--) {
			result = result * 10 + nums[i];
		}
		return (result > Integer.MAX_VALUE) ? -1 : (int) result;
	}
	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
