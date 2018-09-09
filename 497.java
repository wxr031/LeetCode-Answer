class Solution {
	Random random;
	int[][] rectangles;
	int[] area;
	int total;
	public Solution(int[][] rects) {
		random = new Random();
		rectangles = rects;
		area = new int[rects.length + 1];
		for(int i = 0; i < rects.length; i++) {
			rects[i][2] -= rects[i][0] - 1;
			rects[i][3] -= rects[i][1] - 1;
			area[i + 1] = area[i] + rects[i][2] * rects[i][3];
		}
		total = area[rects.length];
	}

	public int[] pick() {
		int pick = Arrays.binarySearch(area, random.nextInt(total));
		if(pick < 0) pick = -pick - 2;
		return new int[] {
            rectangles[pick][0] + random.nextInt(rectangles[pick][2]),
			rectangles[pick][1] + random.nextInt(rectangles[pick][3])
        };
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
