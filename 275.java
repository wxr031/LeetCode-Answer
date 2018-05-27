class Solution {
	public int hIndex(int[] citations) {
		if(citations.length == 0 || citations[citations.length-1] == 0) {
			return 0;
		}
		for(int i = 0; i < citations.length; i++) {
			citations[i] -= citations.length - i;
		}
		int left = 0, right = citations.length-1;
		while(left < right) {
			int mid = left + ((right - left) >> 1);
			if(citations[mid] >= 0) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return citations.length - right;
	}
}

