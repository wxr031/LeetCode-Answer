class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
            }
            else {
                stack.push(i);
            }
        }
        int maxLength = 0;
        int top = s.length();
        while (!stack.empty()) {
            maxLength = Math.max(maxLength, top - stack.peek() - 1);
            top = stack.pop();
        }
        return maxLength;
    }
}
