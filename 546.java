class Solution {
	public int removeBoxes(int[] boxes) {
		int[][][] dp = new int[boxes.length][boxes.length][boxes.length + 1];
		return dfs(dp, boxes, 0, boxes.length - 1, 1);
	}
	private int dfs(int[][][] dp, int[] boxes, int left, int right, int cont) {
		if(right < left) return 0;
		if(dp[left][right][cont] != 0) return dp[left][right][cont];
		int last = boxes[right];
		while(right > left && boxes[right - 1] == last) {
			right--;
			cont++;
		}
		dp[left][right][cont] = dfs(dp, boxes, left, right - 1, 1) + cont * cont;
		for(int mid = left; mid < right; mid++) {
			if(boxes[mid] == last) {
				dp[left][right][cont] = Math.max(dp[left][right][cont],
						dfs(dp, boxes, left, mid, cont + 1)
						+ dfs(dp, boxes, mid + 1, right - 1, 1));
			}
		}
		return dp[left][right][cont];
	}
}
