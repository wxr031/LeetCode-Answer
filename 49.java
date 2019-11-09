class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] counter = new int[256];
			for (char c : str.toCharArray()) {
				counter[c]++;
			}
			StringBuilder sb = new StringBuilder();
			for (int n = 'a'; n <= 'z'; n++) {
				for (int i = 0; i < counter[n]; i++) {
					sb.append(n);
				}
			}
			String sorted = sb.toString();
			map.putIfAbsent(sorted, new ArrayList<>());
			map.get(sorted).add(str);
		}
		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
}
