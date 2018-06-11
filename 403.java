class Solution {
	public boolean canCross(int[] stones) {
		if(stones.length <= 1) return true;
		if(stones[1] != 1) return false;
		Map<Integer,Set<Integer>> mem = new HashMap<>();
		Set<Integer> hasStone = new HashSet<>();
		for(int stone : stones) hasStone.add(stone);
		return dfs(1, 1, stones[stones.length - 1], hasStone, mem);
	}
	private boolean dfs(int jump, int index, int goal, Set<Integer> hasStone, Map<Integer,Set<Integer>> mem) {
		if(index == goal) return true;
		if(jump <= 0 || index > goal || !hasStone.contains(index) || (mem.containsKey(jump) && mem.get(jump).contains(index)))
			return false;
		if(dfs(jump + 1, index + jump + 1, goal, hasStone, mem)) return true;
		if(dfs(jump, index + jump, goal, hasStone, mem)) return true;
		if(dfs(jump - 1, index + jump - 1, goal, hasStone, mem)) return true;
		if(!mem.containsKey(jump)) mem.put(jump, new HashSet<Integer>());
		mem.get(jump).add(index);
		return false;
	}
}
