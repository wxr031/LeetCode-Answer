class Solution {
	public int distributeCandies(int[] candies) {
		Set<Integer> set = new HashSet<>();
		for(int id : candies) {
			set.add(id);
		}
		return Math.min(set.size(), candies.length / 2);
	}
}
