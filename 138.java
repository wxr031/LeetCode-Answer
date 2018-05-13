/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) {
			return null;
		}
		for(RandomListNode curr = head; curr != null; curr = curr.next.next) {
			RandomListNode newNode = new RandomListNode(curr.label);
			newNode.next = curr.next;
			curr.next = newNode;
		}
		for(RandomListNode curr = head; curr != null; curr = curr.next.next) {
			curr.next.random = (curr.random == null) ? null : curr.random.next;
		}
		RandomListNode newHead = head.next;
		for(RandomListNode curr = head; curr != null; curr = curr.next) {
			RandomListNode temp = curr.next;
			curr.next = temp.next;
			temp.next = (curr.next == null) ? null : curr.next.next;
		}
		return newHead;
	}
}
