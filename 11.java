class Solution {
	public int maxArea(int[] height) {
		if(height.length <= 1) {
			return 0;
		}
		int left = 0, right = height.length-1;
		int result = 0;
		while(left <= right) {
			if(height[left] < height[right]) {
				int internalArea = (right - left) * height[left];
				result = Math.max(internalArea, result);
				left++;
			} else {
				int internalArea = (right - left) * height[right];
				result = Math.max(internalArea, result);
				right--;
			}
		}
		return result;
	}
}
