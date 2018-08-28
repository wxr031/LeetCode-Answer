class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int maxLen = 0, curr = 0;
		for (int num : nums) {
			if(num == 1) {
				curr++;
			}
			else {
				maxLen = Math.max(curr, maxLen);
				curr = 0;
			}
		}
		return Math.max(maxLen, curr); 
	} 
}
