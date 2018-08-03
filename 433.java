class Solution {
	public int minMutation(String start, String end, String[] bank) {
		Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
		if(!bankSet.contains(end)) {
			return -1;
		}
		Set<String> been = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		char[] gene = new char[] {'A', 'T', 'G', 'C'};
		queue.offer(start);
		int level = 0, length = start.length();
		while(!queue.isEmpty()) {
			Queue<String> nextQueue = new LinkedList<>();
			while(!queue.isEmpty()) {
				String nowStr = queue.poll();
				if(nowStr.equals(end)) {
					return level;
				}
				char[] nowArr = nowStr.toCharArray();
				been.add(nowStr);
				for(int i = 0; i < length; i++) {
					char temp = nowArr[i];
					for(char g : gene) {
						if(g != temp) {
							nowArr[i] = g;
							String next = new String(nowArr);
							if(!been.contains(next) && bankSet.contains(next)) {
								nextQueue.offer(next);
							}
						}
					}
					nowArr[i] = temp;
				}
			}
			queue.addAll(nextQueue);
			level++;
		}
		return -1;
	}
}
