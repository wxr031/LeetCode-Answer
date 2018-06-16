class Solution {
	public String shiftingLetters(String string, int[] shifts) {
		int accum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = shifts.length - 1; i >= 0; i--) {
			accum += shifts[i];
			if(accum >= 26) accum %= 26;
			sb.insert(0, (char)('a' + (string.charAt(i) - 'a' + accum) % 26));
		}
		return sb.toString();
	}
}
