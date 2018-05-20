class Solution {
	private static final int CHAR_NUM = 26;
	private class TrieNode {
		TrieNode[] child;
		String word;

		TrieNode() {
			child = new TrieNode[CHAR_NUM];
			word = null;
		}

		public void insert(String string) {
			TrieNode curr = this;
			for(int i = 0; i < string.length(); i++) {
				int pos = string.charAt(i) - 'a';
				if(curr.child[pos] == null) {
					curr.child[pos] = new TrieNode();
				}
				curr = curr.child[pos];
			}
			curr.word = string;
		}
	}
	public void search(TrieNode root, int row, int col, char[][] board, List<String> result) {
		if(root.word != null) {
			result.add(root.word);
			root.word = null; // avoid duplication
		}
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '?') return;
		int pos = board[row][col] - 'a';
		if(root.child[pos] == null) return;
		char temp = board[row][col];
		board[row][col] = '?'; // the question mark is used to mark visited grid
		search(root.child[pos], row-1, col, board, result);
		search(root.child[pos], row+1, col, board, result);
		search(root.child[pos], row, col-1, board, result);
		search(root.child[pos], row, col+1, board, result);
		board[row][col] = temp;
	}
	public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = new TrieNode();
		for(String word : words) {
			root.insert(word);
		}
		List<String> result = new ArrayList<>();
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				search(root, r, c, board, result);
			}
		}
		return result;
	}
}
