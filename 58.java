class Solution {
	public int lengthOfLastWord(String string) {
		int result = 0, curr = string.length() - 1;
		while(curr >= 0 && string.charAt(curr) == ' ') {
			curr--;
		}
		while(curr >= 0 && string.charAt(curr) != ' ') {
			curr--;
			result++;
		}
		return result;
	}
}
