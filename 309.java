class Solution {
	public int maxProfit(int[] prices) {
		if(prices.length == 0) {
			return 0;
		}
		int buy[] = new int[2];
		int sell[] = new int[2];
		int curr = 0;
		buy[0] = -prices[0];
		for(int i = 1; i < prices.length; i++) {
			int od = i & 1, op = od ^ 1;
			buy[od] = Math.max(buy[op], sell[od] - prices[i]);
			sell[od] = Math.max(sell[op], buy[op] + prices[i]);
		}
		return sell[(prices.length-1)&1];
	}
}
