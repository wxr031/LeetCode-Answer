class Solution {
	public static int strongPasswordChecker(String string) {
		int length = string.length();
		if(length <= 4) {
			return 6 - length;
		}
		int[] mod = new int[4];
		int lackUpper = 1, lackLower = 1, lackDigit = 1;
		int repeat = 0, redundant = string.length() > 20 ? string.length() - 20 : 0;

        int width = 0;
        char prev = string.charAt(0);
        string += '_';
		for(char curr : string.toCharArray()) {
			if(curr >= 'A' && curr <= 'Z') {
				lackUpper = 0;
			}
			else if(curr >= 'a' && curr <= 'z') {
				lackLower = 0;
			}
			else if(curr >= '0' && curr <= '9') {
				lackDigit = 0;
			}
			if(prev == curr) {
				width++;
			}
			else {
				repeat += width / 3;
				if(width >= 3) {
					mod[(width - 3) % 3 + 1]++;
				}
				mod[3] += (width - 3) / 3;
				width = 1;
				prev = curr;
			}
		}
        
		if(length == 5) {
			return (lackUpper + lackLower + lackDigit <= 1) ? 1 : 2;
		}
        
        int delete = 0;
		for(int i = 1; i <= 3; i++) {
			int deleteChar = Math.min(redundant / i, mod[i]), deleteCharNum = deleteChar * i;
			delete += deleteCharNum;
			redundant -= deleteCharNum;
			repeat -= deleteChar;
		}
		return delete + redundant + Math.max(lackUpper + lackLower + lackDigit, repeat);
	}
}
