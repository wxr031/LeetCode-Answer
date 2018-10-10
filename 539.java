class Solution {
	public int findMinDifference(List<String> timePoints) {
		TreeSet<Integer> set = new TreeSet<>();
		for(String string : timePoints) {
			int num = Integer.parseInt(string.substring(0, 2)) * 60
				+ Integer.parseInt(string.substring(3, 5));
			if(set.contains(num)) return 0;
			set.add(num);
		}
		Integer result = Integer.MAX_VALUE, next;
		for(Integer now : set) {
			if((next = set.higher(now)) == null) break;
			result = Math.min(result, next - now);
		}
		return Math.min(result, set.first() - set.last() + 1440);
	}
}

