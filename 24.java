/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		for(ListNode curr = dummy; curr.next != null && curr.next.next != null; curr = curr.next.next) {
			ListNode next1 = curr.next, next2 = curr.next.next;
			next1.next = next2.next;
			curr.next = next2;
			curr.next.next = next1;
		}
		return dummy.next;
	}
}
