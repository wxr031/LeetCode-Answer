class Solution {
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes.length <= 1) {
			return envelopes.length;
		}
		Arrays.sort(envelopes, new Comparator<int[]>() {
				public int compare(int[] rec1, int[] rec2) {
				return (rec1[0] == rec2[0]) ? rec2[1] - rec1[1] : rec1[0] - rec2[0];
				}
				});
		int[] stack = new int[envelopes.length + 1];
		stack[0] = -1;
		int top = 0;
		for(int i = 0; i < envelopes.length; i++) {
			if(envelopes[i][1] <= stack[top]) binarySearch(stack, top, envelopes[i][1]);
			else stack[++top] = envelopes[i][1];
		}
		return top;
	}
	public void binarySearch(int[] stack, int right, int target) {
		int left = 0;
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if(stack[mid] >= target) right = mid;
			else left = mid;
		}
		stack[right] = target;
	}
}
