class Solution {
	public int maxProfit(int k, int[] prices) {
		if(prices.length == 0 || k == 0) {
			return 0;
		}
		int[] hold = new int[k];
		int[] sell = new int[k];
		Arrays.fill(hold, Integer.MIN_VALUE);
		for(int i = 0; i < prices.length; i++) {
			for(int n = k-1; n >= 0; n--) {
				sell[n] = Math.max(sell[n], hold[n] + prices[i]);
				hold[n] = Math.max(hold[n], ((n == 0) ? 0 : sell[n-1]) - prices[i]);
			}
		}
		return sell[k-1];
	}
}
