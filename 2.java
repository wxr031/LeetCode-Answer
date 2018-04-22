/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		ListNode result = new ListNode(0); // dummy node
		ListNode head = result;
		int carry = 0;
		while(list1 != null && list2 != null) {
			int add = list1.val + list2.val + carry;
			carry = add / 10;
			result = result.next = new ListNode(add % 10);
			list1 = list1.next;
			list2 = list2.next;
		}
		while(list1 != null) {
			int add = list1.val + carry;
			carry = add / 10;
			result = result.next = new ListNode(add % 10);
			list1 = list1.next;
		}
		while(list2 != null) {
			int add = list2.val + carry;
			carry = add / 10;
			result = result.next = new ListNode(add % 10);
			list2 = list2.next;
		}
		if(carry == 1) result.next = new ListNode(1);
		return head.next;
	}
}
