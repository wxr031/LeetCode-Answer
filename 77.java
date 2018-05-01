class Solution {
	public List<List<Integer>> combine(int n, int k) {
		if(n == 0 || n < k) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combineUtil(result, temp, n, k, 1);
		return result;
	}
	public void combineUtil(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
		if(k == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = start; i <= n - k + 1; i++) {
			temp.add(i);
			combineUtil(result, temp, n, k-1, i+1);
			temp.remove(temp.size()-1);
		}
	}
}
