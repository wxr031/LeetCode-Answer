class Solution {
	public int findContentChildren(int[] childs, int[] cookies) {
		Arrays.sort(childs);
		Arrays.sort(cookies);
		int child = 0, cookie = 0;
		while(child < childs.length && cookie < cookies.length) {
			if(childs[child] <= cookies[cookie]) {
				child++;
			}
			cookie++;
		}
		return child;
	}
}
