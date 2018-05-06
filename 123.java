class Solution {
	public int maxProfit(int[] prices) {
		int sell2 = 0, hold2 = Integer.MIN_VALUE, sell1 = 0, hold1 = Integer.MIN_VALUE;
		for(int i = 0; i < prices.length; i++) {
			sell2 = Math.max(sell2, hold2 + prices[i]);
			hold2 = Math.max(hold2, sell1 - prices[i]);
			sell1 = Math.max(sell1, hold1 + prices[i]);
			hold1 = Math.max(hold1, -prices[i]);
		}
		return sell2;
	}
}
