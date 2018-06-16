class Solution {
	public int maxDistToClosest(int[] seats) {
		int leftMargin = 0, rightMargin = seats.length - 1;
		while(seats[leftMargin] == 0) leftMargin++;
		while(seats[rightMargin] == 0) rightMargin--;
		int result = Math.max(leftMargin, seats.length - rightMargin - 1);
		int left = leftMargin, right = left + 1;
		while(left <= rightMargin) {
			while(right <= rightMargin && seats[right] == 0) right++;
			if(right <= rightMargin)
				result = Math.max(result, (right - left) >> 1);
			left = right;
			right = left + 1;
		}
		return result;
	}
}
