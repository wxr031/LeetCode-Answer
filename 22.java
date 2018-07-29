class Solution {
	public List<String> generateParenthesis(int num) {
		if(num == 0) return Collections.singletonList(" ");
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		generateUtil(result, num, 0, 0, sb);
		return result;
	}
	public void generateUtil(List<String> result, int num, int left, int pair, StringBuilder sb) {
		if(left == 0) {
			sb.append('(');
			generateUtil(result, num, left + 1, pair, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		else if(left + pair == num) {
			for(int i = 0; i < left; i++) {
				sb.append(')');
			}
			result.add(sb.toString());
			sb.delete(sb.length() - left, sb.length());
		}
		else {
			sb.append('(');
			generateUtil(result, num, left + 1, pair, sb);
			sb.setCharAt(sb.length() - 1, ')');
			generateUtil(result, num, left - 1, pair + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
