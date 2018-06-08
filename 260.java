class Solution {
	public int[] singleNumber(int[] nums) {
		int xor = 0;
		for(int num : nums) {
			xor ^= num;
		}
		int last_one = xor & (-xor);
        int[] answer = new int[2];
		for(int num : nums) {
			if((num & last_one) == 0) answer[0] ^= num;
			else answer[1] ^= num;
		}
		return answer;
	}
}
