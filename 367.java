class Solution {
	public boolean isPerfectSquare(int num) {
		int left = 0, right = num / 2 + 1;
		while(left <= right) {
			int mid = left + ((right - left) >> 1);
			long mul = (long)mid * mid;
			if(mul > num) right = mid - 1;
			else if(mul < num) left = mid + 1;
			else return true;
		}
		return false;
	}
}
