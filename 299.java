class Solution {
	public String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] count = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int secretNum = secret.charAt(i) - '0', guessNum = guess.charAt(i) - '0';
			if (secretNum == guessNum) bulls++;
			else {
				if (count[secretNum]++ < 0) cows++;
				if (count[guessNum]-- > 0) cows++;
			}
		}
		return (bulls + "A" + cows + "B");
	}
}
