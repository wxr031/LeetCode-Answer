class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		int indexCount = 0;
		for(int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String key = String.valueOf(temp);
			if(!map.containsKey(key)) {
				map.put(key, indexCount++);
				result.add(new ArrayList<String>());
			}
			result.get(map.get(key)).add(strs[i]);
		}
		return result;
	}
}
