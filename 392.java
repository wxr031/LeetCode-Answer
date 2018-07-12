class Solution {
	public boolean isSubsequence(String seq, String str) {
		if(seq.length() == 0) return true;
		int point1 = 0, point2 = 0;
		while(point1 < str.length() && point2 < seq.length()) {
			if(str.charAt(point1) == seq.charAt(point2)) {
				point2++;
			}
			point1++;
		}
		return point2 == seq.length();
	}
}
