class Solution {
	public int lastRemaining(int num) {
		boolean front = true;
		int remain = num, gap = 1, head = 1;
		while(remain != 1) {
			if(front || (remain & 1) != 0) {
				head += gap;
			}
			front = !front;
			gap <<= 1;
			remain >>= 1;
		}
		return head;
	}
}
