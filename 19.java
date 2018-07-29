/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head, slow = head;
		int i;
		for(i = 0; i < n + 1 && fast != null; i++) {
			fast = fast.next;
		}
		if(i == n) {
			return head.next;
		}
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
