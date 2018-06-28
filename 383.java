class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] ransom = new int[26], magazine = new int[26];
		for(char c : magazine.toCharArray()) {
			magazine[c - 'a']++;
		}
		for(char c : ransom.toCharArray()) {
			if(magazine[c - 'a']-- == 0) {
				return false
			}
		}
		return true;
	}
}
