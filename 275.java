class Solution {
	public int hIndex(int[] citations) {
		if(citations.length == 0 || citations[citations.length-1] == 0) {
			return 0;
		}
		int left = 0, right = citations.length-1;
		while(left < right) {
			int mid = left + ((right - left) >> 1);
			if(citations[mid] >= citations.length - mid) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return citations.length - right;
	}
}
