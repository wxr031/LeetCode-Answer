class Solution {
	public String intToRoman(int num) {
		String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] digits = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < romans.length; i++) {
			while(num >= digits[i]) {
				sb.append(romans[i]);
				num -= digits[i];
			}
		}
		return sb.toString();
	}
}
