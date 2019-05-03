/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> preorder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            preorder.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return preorder;
    }
}
