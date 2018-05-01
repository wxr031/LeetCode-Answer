class Solution {
	public String simplifyPath(String path) {
		String[] directories = path.split("/");
		Deque<String> deque = new ArrayDeque<>();
		for(String dir : directories) {
			if(dir.equals("..") && !deque.isEmpty()) {
				deque.pollLast();
			}
			else if(!dir.equals("") && !dir.equals(".") && !dir.equals("..")) {
				deque.offerLast(dir);
			}
		}
		if(deque.isEmpty()) {
			return "/";
		}
		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()) {
			sb.append("/");
			sb.append(deque.pollFirst());
		}
		return sb.toString();
	}
}
