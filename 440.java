class Solution {
	public int findKthNumber(int num, int k) {
		if(k > num) return -1;
		int curr = 1, step = 1;
		while(step != k) {
			long between = numberBetween((long)(curr), (long)(curr + 1), num);
			if(step + between > k) {
				curr *= 10;
				step++;
			}
			else {
				curr++;
				step += between;
			}
		}
		return curr;
	}
	private int numberBetween(long curr, long next, int num) {
		int total = 0;
		while(curr <= num) {
			total += Math.min(next, num + 1) - curr;
			curr *= 10;
			next *= 10;
		}
		return total;
	}
}
