class LRUCache {
	private class ListNode {
		int value, key;
		ListNode next, prev;

		private ListNode(int key, int value) {
			this.key = key;
			this.value = value;
			prev = next = null;
		}
	}

	ListNode head, tail;
	Map<Integer,ListNode> map;
	int remain;

    public LRUCache(int capacity) {
        remain = capacity;
		head = tail = new ListNode(-1, -1);
		map = new HashMap<Integer,ListNode>();
    }
    
	public void moveToTail(ListNode curr) {
        if(curr == tail) return;
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
		tail.next = curr;
		curr.prev = tail;
		curr.next = null;
		tail = curr;
	}

    public int get(int key) {
        if(map.containsKey(key)) {
			moveToTail(map.get(key));
			return tail.value;
		}
		else {
			return -1;
		}
        
    }
    
    public void put(int key, int value) {
		if(map.containsKey(key)) {
			moveToTail(map.get(key));
            map.get(key).value = value;
		}
		else {
			tail.next = new ListNode(key, value);
			tail.next.prev = tail;
			tail = tail.next;
			if(remain == 0) {
				map.remove(head.next.key);
				head.next = head.next.next;
				head.next.prev = head;
			}
			else {
				remain--;
			}
		}
		map.put(key, tail);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
