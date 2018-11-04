class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if(!set.contains(endWord)) {
			return 0;
		}
		int length = 1;
		Queue<String> queue = new ArrayDeque<>();
		queue.offer(beginWord);
		set.remove(beginWord);
		while(!queue.isEmpty()) {
			Set<String> temp = new HashSet<>();
			while(!queue.isEmpty()) {
				String word = queue.poll();
				char[] seq = word.toCharArray();
				for(int i = 0; i < seq.length; i++) {
					char origin = seq[i];
					for(char c = 'a'; c <= 'z'; c++) {
						if(c != origin) {
							seq[i] = c;
							String next = new String(seq);
							if(next.equals(endWord)) {
								return length + 1;
							}
							if(set.contains(next)) {
								temp.add(next);
							}
						}
					}
					seq[i] = origin;
				}
			}
			for(String word : temp) {
				set.remove(word);
			}
			queue = new ArrayDeque<>(temp);
			length++;
		}
		return 0;
	}
}

