class NumArray {

	int[] segment;
	int length;

	public NumArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			segment = null;
			length = 0;
		}
		else {
			segment = new int[nums.length << 1];
			length = nums.length;
			for(int i = 0; i < nums.length; i++) {
				segment[i + nums.length] = nums[i];
			}
			for(int i = nums.length-1; i > 0; i--) {
				segment[i] = segment[i << 1] + segment[(i << 1) + 1];
			}
		}
	}

	public void update(int i, int val) {
		assert i >= 0 && i < length;
		segment[i + length] = val;
		for(int pos = (i + length) >> 1; pos > 0; pos >>= 1) {
			segment[pos] = segment[pos << 1] + segment[(pos << 1) + 1];
		}
	}

	public int sumRange(int i, int j) {
		assert i >= 0 && i < length && j >= 0 && j < length;
		int sum = 0;
		for(int left = i + length, right = j + length; left <= right; left >>= 1, right >>= 1) {
			if((left & 1) == 1) {
				sum += segment[left++];
			}
			if((right & 1) == 0) {
				sum += segment[right--];
			}
		}
		return sum;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

