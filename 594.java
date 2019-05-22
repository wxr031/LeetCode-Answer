class Solution {
	public int findLHS(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int length = 0;
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (map.containsKey(entry.getKey() + 1)) {
				int length0 = entry.getValue() + map.get(entry.getKey() + 1);
				length = Math.max(length, length0);
			}
		}
		return length;
	}
}
