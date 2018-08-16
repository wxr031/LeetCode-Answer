public class Solution {
	public String reverseWords(String string) {
		String[] words = string.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = words.length - 1; i > 0; i--) {
			sb.append(words[i]);
			sb.append(" ");
		}
		sb.append(words[0]);
		return sb.toString();
	}
}
