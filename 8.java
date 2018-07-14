class Solution {
	public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
		int pos = 0, sign = 1, abs = 0;
        while (pos < str.length() && str.charAt(pos) == ' ') {
			pos++;
		}
        if(pos == str.length()) return 0;
		if(str.charAt(pos) == '+') {
			pos++;
		}
		else if(str.charAt(pos) == '-') {
			sign = -1;
			pos++;
		}
		int bound = Integer.MAX_VALUE / 10;
        while (pos < str.length() && Character.isDigit(str.charAt(pos))) {
            if (abs > bound || (abs == bound && str.charAt(pos) > '7')) {
                if (sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            abs = abs * 10 + str.charAt(pos++) - '0';
        }
        return sign * abs;
    }
}
