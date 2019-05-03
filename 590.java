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
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> postorder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            postorder.add(curr.val);
            for (Node next : curr.children) {
                stack.push(next);
            }
        }
        Collections.reverse(postorder);
        return postorder;
    }
}
