class Solution {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		int[] count1 = new int[26], count2 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			int cid1 = s1.charAt(i) - 'a';
			int cid2 = s2.charAt(i) - 'a';
			count1[cid1]++;
			count2[cid2]++;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			if (validate(count1, count2)) {
				return true;
			}
			int leftChar = s2.charAt(i - s1.length()) - 'a';
			int rightChar = s2.charAt(i) - 'a';
			count2[leftChar]--;
			count2[rightChar]++;
		}
		return validate(count1, count2);
	}
	private boolean validate(int[] count1, int[] count2) {
		for (int i = 0; i < 26; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}
}

