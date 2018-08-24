import java.util.*;
class Solution {
	private static class Trie {
		Trie[] childs;
		boolean endOfWord;
		int childNum;
		Trie() {
			childs = new Trie[26];
			endOfWord = false;
			childNum = 0;
		}
		void insert(String string) {
			Trie curr = this;
			for(char c : string.toCharArray()) {
				int charPos = c - 'a';
				if(curr.childs[charPos] == null) {
					curr.childs[charPos] = new Trie();
				}
				curr.childNum++;
				curr = curr.childs[charPos];
			}
			curr.endOfWord = true;
		}
		boolean search(String string, int start, int end) {
			Trie curr = this;
			for(int i = start; i <= end; i++) {
				int charPos = string.charAt(i) - 'a';
				if(curr.childs[charPos] == null) {
					return false;
				}
				curr = curr.childs[charPos];
			}
			return curr.endOfWord;
		}
	}
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		if(words.length == 0) return new ArrayList<String>();
		Arrays.sort(words, (String str1, String str2) -> {return str1.length() > str2.length() ? 1 : -1;});
		Trie trie = new Trie();
		trie.insert(words[0]);
		List<String> result = new ArrayList<>();
		for(int i = 1; i < words[i].length(); i++) {
			if(words[i].length() == words[i - 1].length()) {
				trie.insert(words[i]);
				continue;
			}
			List<Integer> candidates = Collections.singletonList(0);
			for(int x = 0; x < words[i].length(); x++) {
				for(int cand : candidates) {
					if(trie.search(words[i], cand, x)) {
						candidates.add(x + 1);
					}
				}
			}
			if(candidates.get(candidates.size() - 1) == words[i].length()) {
				result.add(words[i]);
			}
			if(i < words[i].length() - 1) {
				trie.insert(words[i]);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String[] words = new String[] {"cat", "dogs", "cats", "cats"};
		findAllConcatenatedWordsInADict(words);
	}
}
