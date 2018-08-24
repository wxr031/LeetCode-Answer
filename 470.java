/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution {
	public int rand10() {
		int temp = 40;
		while(temp >= 40) {
			temp = (rand7() - 1) * 7 + (rand7() - 1);
		}
		return temp % 10 + 1;
	}
}
