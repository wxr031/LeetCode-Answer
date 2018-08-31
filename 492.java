class Solution {
	public int[] constructRectangle(int area) {
		int root = (int)Math.sqrt(area) + 1;
		while(area % --root != 0);
		return new int[] {area / root, root};
	}
}
