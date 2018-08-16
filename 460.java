class LFUCache {

	int remain, minFreq;
	HashMap<Integer, int[]> data; // [value, count]
	HashMap<Integer, LinkedHashSet<Integer>> freq;

	public LFUCache(int capacity) {
		remain = (capacity > 0) ? capacity : -1;
		minFreq = 0;
		data = new HashMap<>();
		freq = new HashMap<>();
	}

	public int get(int key) {
		if(!data.containsKey(key) || remain == -1) {
			return -1;
		}
		int count = data.get(key)[1];
		data.get(key)[1] = count + 1;
		freq.get(count).remove(key);
		if(freq.get(minFreq).size() == 0) {
			minFreq++;
		}
		if(!freq.containsKey(count + 1)) {
			freq.put(count + 1, new LinkedHashSet<>());
		}
		freq.get(count + 1).add(key);
		return data.get(key)[0];
	}

	public void put(int key, int value) {
		if(remain == -1) {
			return;
		}
		if(data.containsKey(key)) {
			data.get(key)[0] = value;
			get(key);
			return;
		}
		if(remain == 0) {
			int delete = freq.get(minFreq).iterator().next();
			freq.get(minFreq).remove(delete);
			if(freq.get(minFreq).size() == 0) {
				freq.remove(minFreq);
			}
			data.remove(delete);
		}
		else {
			remain--;
		}
		minFreq = 1;
		data.put(key, new int[] {value, 1});
		freq.putIfAbsent(1, new LinkedHashSet<>());
		freq.get(1).add(key);
	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
