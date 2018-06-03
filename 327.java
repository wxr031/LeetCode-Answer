class Solution {
	public int countRangeSum(int[] nums, int lower, int upper) {
		if(lower > upper) return 0;
		long[] suffix = new long[nums.length + 1];
		long[] aux = new long[nums.length + 1];
		for(int i = 1; i <= nums.length; i++) {
			suffix[i] = suffix[i-1] + nums[i-1];
		}
		return mergeSort(suffix, aux, 0, nums.length, lower, upper);
	}
	private int mergeSort(long[] suffix, long[] aux, int left, int right, int lower, int upper) {
		if(right == left) return 0;
		int mid = left + ((right - left) >> 1);
		return mergeSort(suffix, aux, left, mid, lower, upper)
			+ mergeSort(suffix, aux, mid+1, right, lower, upper)
			+ merge(suffix, aux, left, mid, right, lower, upper);
	}
	private int merge(long[] suffix, long[] aux, int leftStart, int leftEnd, int rightEnd, int lower, int upper) {
		int total = 0;
		int left = leftStart, right = leftEnd + 1, top = leftStart;
		for(int rangeStart = leftEnd + 1; left <= leftEnd; left++) {
			while(rangeStart <= rightEnd && suffix[rangeStart] - suffix[left] < lower) rangeStart++;
			int rangeEnd = rangeStart;
			while(rangeEnd <= rightEnd && suffix[rangeEnd] - suffix[left] <= upper) rangeEnd++;
			total += rangeEnd - rangeStart;
			while(right <= rightEnd && suffix[right] < suffix[left]) aux[top++] = suffix[right++];
			aux[top++] = suffix[left];
		}
		System.arraycopy(aux, leftStart, suffix, leftStart, right - leftStart);
		return total;
	}
}
