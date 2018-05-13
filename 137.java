class Solution {
	public int singleNumber(int[] nums) {
		int front = 0, back = 0;
		for(int num : nums) {
			back = ~front & (num ^ back);
			front = ~back & (num ^ front);
		}
		return back;
	}
}
