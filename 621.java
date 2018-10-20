class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for(char c : tasks) {
			count[c - 'A']++;
		}
		int max = 0, max_num = 0;
		for(char c = 0; c < 26; c++) {
			max = Math.max(max, count[c]);
		}
		for(char c = 0; c < 26; c++) {
			if(count[c] == max)
				max_num++;
		}
		if(max_num > n + 1) return tasks.length;
		return max * max_num + Math.max((n - max_num + 1) * (max - 1),
				tasks.length - max * max_num);
	}
}

