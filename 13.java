class Solution {
	public int romanToInt(String s) {
		int total = 0;
		int[] value = new int[256];
		value['I'] = 1;
		value['V'] = 5;
		value['X'] = 10;
		value['L'] = 50;
		value['C'] = 100;
		value['D'] = 500;
		value['M'] = 1000;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i == s.length() - 1) {
				total += value[ch];
				break;
			}
			char nch = s.charAt(i + 1);
			if (value[ch] < value[nch]) {
				total -= value[ch];
			}
			else {
				total += value[ch];
			}
		}
		return total;
	}
}
