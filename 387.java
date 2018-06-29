class Solution {
	public int firstUniqChar(String string) {
		int[] count = new int[128];
		for(char c : string.toCharArray()) {
			count[c]++;
		}
		int index = 0;
		for(char c : string.toCharArray()) {
			if(count[c] == 1) {
				return index;
			}
			index++;
		}
		return -1;
	}
}
