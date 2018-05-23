class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(result, temp, k, n, 1);
		return result;
	}
	public void dfs(List<List<Integer>> result, List<Integer> temp, int k, int n, int init) {
		if(k == 0) {
			if(n == 0) result.add(new ArrayList<Integer>(temp));
			return;
		}
		if(init > n) return;
		for(int i = init; i <= 9; i++) {
			temp.add(i);
			dfs(result, temp, k - 1, n - i, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
