class Solution {
	public String frequencySort(String string) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : string.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(1,
				new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
				return entry2.getValue() - entry1.getValue();
			}
		});
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(entry);
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			for(int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
	}	
}

