/*
// Definition for a Node.
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node() {}

	public Node(int _val,Node _prev,Node _next,Node _child) {
		val = _val;
		prev = _prev;
		next = _next;
		child = _child;
	}
};
 */
class Solution {
	public Node flatten(Node head) {
		flattenUtil(head);
		return head;
	}
	private Node flattenUtil(Node curr) {
		Node prevNode = null;
		while(curr != null) {
			if(curr.child != null) {
				Node nextTail = flattenUtil(curr.child), nextHead = curr.next;
				curr.next = curr.child;
				curr.child.prev = curr;
				curr.child = null;
				nextTail.next = nextHead;
				if(nextHead != null) {
					nextHead.prev = nextTail;
				}
			}
			prevNode = curr;
			curr = curr.next;
		}
		return prevNode;
	}
}
