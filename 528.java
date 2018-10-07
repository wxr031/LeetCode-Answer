import java.util.*;
class Solution {

	int[] accum;
	int maxAccum;
	Random random;

	public Solution(int[] w) {
		accum = new int[w.length + 1];
		for(int i = 0; i < w.length; i++) {
			accum[i + 1] = accum[i] + w[i];
		}
		maxAccum = accum[w.length];
		random = new Random();
	}

	public int pickIndex() {
		int pick = random.nextInt(maxAccum);
		int index = Arrays.binarySearch(accum, pick);
		if(index < 0) index = -index - 2;
		return index;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

