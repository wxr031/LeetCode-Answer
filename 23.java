/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		return mergeTwoLists(
				mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
				mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));
	}
	private ListNode mergeTwoLists(ListNode node0, ListNode node1) {
		if (node0 == null) {
			return node1;
		}
		if (node1 == null) {
			return node0;
		}
		if (node0.val < node1.val) {
			node0.next = mergeTwoLists(node0.next, node1);
			return node0;
		}
		else {
			node1.next = mergeTwoLists(node0, node1.next);
			return node1;
		}
	}
}
