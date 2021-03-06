/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

	private ListNode head;
	private Random random;

	/** @param head The linked list's head.
	  Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
		this.head = head;
		this.random = new Random();
	}

	/* Returns a random node's value. */
	public int getRandom() {
		int reservoir = head.val, count = 1;
		for(ListNode curr = head.next; curr != null; curr = curr.next) {
			if(random.nextInt(count + 1) == 0) {
				reservoir = curr.val;
			}
			count++;
		}
		return reservoir;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
