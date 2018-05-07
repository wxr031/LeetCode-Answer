/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		while(root != null) {
			TreeLinkNode dummy = new TreeLinkNode(-1);
			TreeLinkNode trace = dummy;
			while(root != null) {
				if(root.left != null) {
					trace = trace.next = root.left;
				}
				if(root.right != null) {
					trace = trace.next = root.right;
				}
				root = root.next;
			}
			root = dummy.next;
		}
	}
}
