class Solution {
	public String originalDigits(String s) {
		int[] count = new int[64];
		for(char c : s.toCharArray()) {
			if (c == 'z') count['0']++; // 0
			else if (c == 'o') count['1']++; // 0 + 1 + 2 + 4
			else if (c == 'w') count['2']++; // 2
			else if (c == 'h') count['3']++; // 3 + 8
			else if (c == 'u') count['4']++; // 4
			else if (c == 'f') count['5']++; // 5 + 7
			else if (c == 'x') count['6']++; // 6
			else if (c == 's') count['7']++; // 6 + 7
			else if (c == 'g') count['8']++; // 8
			else if (c == 'i') count['9']++; // 5 + 6 + 8 + 9
		}
		count['3'] -= count['8'];
		count['5'] -= count['4'];
		count['7'] -= count['6'];
		count['1'] -= count['0'] + count['2'] + count['4'];
		count['9'] -= count['5'] + count['6'] + count['8'];
		StringBuilder sb = new StringBuilder();
		for (char c = '0'; c <= '9'; c++){
			for (int i = 0; i < count[c]; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
