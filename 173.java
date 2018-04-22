/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Stack;
public class BSTIterator {

	private Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !(stack.empty());
	}

	/** @return the next smallest number */
	public int next() {
		assert !stack.empty();
		TreeNode returnNode = stack.pop(), rightNode = returnNode.right;
		while(rightNode != null) {
			stack.push(rightNode);
			rightNode = rightNode.left;
		}
		return returnNode.val;
	}
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
