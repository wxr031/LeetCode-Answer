class Solution {
	public static class Freq implements Comparable<Freq> {
		public int key, freq;
		Freq(int key, int freq) {
			this.key = key;
			this.freq = freq;
		}
		@Override
			public int compareTo(Freq f1) {
				return this.freq <= f1.freq ? 1 : -1;
			}
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int num : nums) {
			if(map.containsKey(num)) map.put(num, map.get(num) + 1);
			else map.put(num, 1);
		}
		List<Freq> temp = new ArrayList<>();
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			temp.add(new Freq(entry.getKey(), entry.getValue()));
		}
		PriorityQueue<Freq> pq = new PriorityQueue<>(temp);
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			result.add(pq.poll().key);
		}
		return result;
	}
}

