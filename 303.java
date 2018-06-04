class NumArray {

	private int[] fenwick;

	public NumArray(int[] nums) {
		fenwick = new int[nums.length + 1];
		for(int i = 1; i <= nums.length; i++)
			for(int j = i; j <= nums.length; j += (j & (-j)))
				fenwick[j] += nums[i-1];
	}

	public int sumRange(int i, int j) {
        return sumRangeFrom0(j+1) - sumRangeFrom0(i);
	}

	private int sumRangeFrom0(int i) {
		int sum = 0;
		for(int j = i; j > 0; j -= (j & (-j)))
            sum += fenwick[j];
		return sum;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

