/**
 * Definition for singly-linked list.
 * public class ListNode {
 *	 int val;
 *	 ListNode next;
 *	 ListNode(int x) { val = x; }
 * }
 */
class Solution {
	ListNode mergeTwoList(ListNode node1, ListNode node2) {
		if(node1 == null) return node2;
		if(node2 == null) return node1;
		if(node1.val < node2.val) {
			node1.next = mergeTwoList(node1.next, node2);
			return node1;
		} else {
			node2.next = mergeTwoList(node1, node2.next);
			return node2;
		}
	}
	ListNode mergeKListUtil(ListNode[] lists, int left, int right) {
		if(left == right) return lists[left];
		int mid = left + (right-left) / 2;
		return mergeTwoList(mergeKListUtil(lists, left, mid), mergeKListUtil(lists, mid+1 ,right));
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(list == null || lists.length == 0) return null;
		return mergeKListUtil(lists, 0, lists.length-1);
	}
}
