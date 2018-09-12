class Solution {
	public int uniqueLetterString(String string) {
		List<List<Integer>> indices = new ArrayList<>();
		for(int i = 0; i < 26; i++) indices.add(new ArrayList<Integer>());
		for(int i = 0; i < string.length(); i++) {
			List<Integer> list = indices.get(string.charAt(i) - 'A');
			if(list.size() == 0) list.add(-1);
			list.add(i);
		}
		int unique = 0;
		for(int ch = 0; ch < 26; ch++) {
			List<Integer> list = indices.get(ch);
			if(list.size() != 0) {
				list.add(string.length());
				for(int i = 1; i < list.size() - 1; i++) {
					unique += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
				}
			}
		}
		return unique;
	}
}
