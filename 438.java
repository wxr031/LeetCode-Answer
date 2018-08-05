class Solution {
	public List<Integer> findAnagrams(String string, String pattern) {
		int[] patternCount = new int[128], stringCount = new int[128];
		List<Integer> result = new ArrayList<>();
		int count = 0;
		for(char now : pattern.toCharArray()) {
			patternCount[now]++;
		}
		for(int i = 0; i < string.length(); i++) {
			char now = string.charAt(i);
			if(stringCount[now]++ < patternCount[now]) {
				count++;
			}
			if(i >= pattern.length() - 1) {
				if(count == pattern.length()) {
					result.add(i - pattern.length() + 1);
				}
				char prev = string.charAt(i - pattern.length() + 1);
				if(--stringCount[prev] < patternCount[prev]) {
					count--;
				}
			}
		}
		return result;
	}
}
