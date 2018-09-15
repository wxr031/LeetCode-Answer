class Solution {
	public int numBusesToDestination(int[][] routes, int S, int T) {
		if(S == T) return 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int bus = 0; bus < routes.length; bus++) {
			for(int stop = 0; stop < routes[bus].length; stop++) {
				map.putIfAbsent(routes[bus][stop], new ArrayList<Integer>());
				map.get(routes[bus][stop]).add(bus);
			}
		}
		Queue<Integer> queue = new ArrayDeque<>();
		HashSet<Integer> been = new HashSet<>();
		queue.addAll(map.get(S));
		int take = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0; s < size; s++) {
				int curr = queue.poll();
				if(been.contains(curr)) continue;
				been.add(curr);
				for(int bus : routes[curr]) {
					if(bus == T) return take;
					for(int next : map.get(bus)) {
						if(been.contains(next)) continue;
						queue.add(next);
					}
				}
			}
			take++;
		}
		return -1;
	}
}
