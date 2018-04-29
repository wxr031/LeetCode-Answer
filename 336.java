class Solution {
	public static final int CHAR_NUM = 26;

	public static class TrieNode {
		private TrieNode[] child;
		private int endIndex;
		private Map<Integer,Integer> map;

		TrieNode() {
			child = new TrieNode[CHAR_NUM];
			map = new TreeMap<>();
			endIndex = -1;
		}

		public void insert(int index, String[] words) {
			TrieNode crawl = this;
			for(int i = 0; i < words[index].length(); i++) {
				int charPos = words[index].charAt(i) - 'a';
				if(crawl.child[charPos] == null) {
					crawl.child[charPos] = new TrieNode();
				}
				crawl.map.put(index, i);
				crawl = crawl.child[charPos];
			}
			crawl.endIndex = index;
			crawl.map.put(index, words[index].length());
		}

		public void find(int index, String[] words, List<List<Integer>> result) {
			TrieNode crawl = this;
			for(int i = words[index].length()-1; i >= 0; i--) {
				int charPos = words[index].charAt(i) - 'a';
				if(crawl.endIndex >= 0 && isPalindrome(words[index], 0, i)) {
					result.add(Arrays.asList(crawl.endIndex, index));
				}
				if(crawl.child[charPos] == null) {
					return;
				}
				crawl = crawl.child[charPos];
			}
			for(Map.Entry<Integer,Integer> entry : crawl.map.entrySet()) {
				int index2 = entry.getKey();
				if(index != index2 && isPalindrome(words[index2], entry.getValue(), words[index2].length()-1)) {
					result.add(Arrays.asList(index2, index));
				}
			}
		}
		public boolean isPalindrome(String string, int start, int finish) {
			for(int i = start, j = finish; i <= j; i++, j--) {
				if(string.charAt(i) != string.charAt(j)) {
					return false;
				}
			}
			return true;
		}	
	}

	public List<List<Integer>> palindromePairs(String[] words) { 
		List<List<Integer>> result = new ArrayList<>();
		if(words == null || words.length == 0) return result;
		TrieNode root = new TrieNode();
		for(int i = 0; i < words.length; i++) {
			root.insert(i, words);
		}
		for(int i = 0; i < words.length; i++) {
			root.find(i, words, result);
		}
		return result;
	}
}
