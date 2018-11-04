class Solution {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			if(!set.contains(num)) {
				Integer left = map.getOrDefault(num - 1, null);
				Integer right = map.getOrDefault(num + 1, null);
				if(left != null && right != null) {
					map.remove(num - 1);
					map.remove(num + 1);
					map.put(left, right);
					map.put(right, left);
				}
				else if(left != null) {
					map.remove(num - 1);
					map.put(left, num);
					map.put(num, left);
				}
				else if(right != null) {
					map.remove(num + 1);
					map.put(right, num);
					map.put(num, right);
				}
				else {
					map.put(num, num);
				}
				set.add(num);
			}
		}
		int result = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			result = Math.max(result, entry.getValue() - entry.getKey() + 1);
		}
		return result;
	}
}
