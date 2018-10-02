class Solution {
	int count = 0;
	public int countArrangement(int num) {
		dfs(num, 1, 0);
		return count;
	}
	private void dfs(int num, int now, int been) {
		if(now > num) {
			count++;
			return;
		}
		for(int i = 1; i <= num; i++) {
			if((been & (1 << i)) == 0 && 
					(now % i == 0 || i % now == 0)) {
				dfs(num, now + 1, been | (1 << i));
			}
		}
	}
}
