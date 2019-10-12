class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesis(result, new StringBuilder(), 0, 0, n);
		return result;
	}
	private void generateParenthesis(List<String> result, StringBuilder sb, int leftNum, int curr, int n) {
		if (curr == 2 * n) {
			result.add(sb.toString());
			return;
		}
		if (2 * leftNum - curr > 0) {
			sb.append(')');
			generateParenthesis(result, sb, leftNum, curr + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (leftNum < n) {
			sb.append('(');
			generateParenthesis(result, sb, leftNum + 1, curr + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}

