class LFUCache {

	PriorityQueue<HashMap<Integer, Integer>> pq;
	int capacity;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		pq = new PriorityQueue<>(capacity, (Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2)
				-> {return entry1.getValue});
	}

	public int get(int key) {

	}

	public void put(int key, int value) {

	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
