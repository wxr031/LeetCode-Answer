class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>(Arrays.asList(0));
		for(int i = 0; i < n; i++) {
			for(int j = (1 << i) - 1; j >= 0; j--) {
				result.add(result.get(j) | (1 << i));
			}
		}
		return result;
	}
}
