class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>(Arrays.asList(0));
		for(int i = 0; i < n; i++) {
			result.add(i ^ (i>>1));
		}
		return result;
	}
}
