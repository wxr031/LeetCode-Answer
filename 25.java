/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode nextHead = head;
		while (nextHead != null && count < k) {
			nextHead = nextHead.next;
			count++;
		}
		if (count == k) {
			ListNode prev = reverseKGroup(nextHead, k);
			ListNode curr = head;
			for (int i = 0; i < k; i++) {
				ListNode next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			return prev;
		}
		return head;
	}
}
