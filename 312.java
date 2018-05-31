class Solution {
	public int maxCoins(int[] nums) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		for(int num : nums) {
			if(num != 0) list.add(num);
		}
		list.add(1);
		int[][] dp = new int[list.size()][list.size()];
		for(int gap = 2; gap < list.size(); gap++) {
			for(int i = 0; i < list.size() - gap; i++) {
				int j = i + gap;
				for(int k = i + 1; k < j; k++) {
					dp[i][j] = Math.max(list.get(i) * list.get(j) * list.get(k)
							+ dp[i][k] + dp[k][j], dp[i][j]);
				}
			}
		}
		return dp[0][list.size()-1];
	}
}
