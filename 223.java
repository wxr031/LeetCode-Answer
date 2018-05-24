class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = rectangleArea(A, B, C, D), area2 = rectangleArea(E, F, G, H); 
		int areaOverlap = rectangleArea(Math.max(A, E), Math.max(B, F), Math.min(C, G), Math.min(D, H));
		return area1 + area2 - areaOverlap;
	}
	public int rectangleArea(int A, int B, int C, int D) {
		return C > A && D > B ? (C - A) * (D - B) : 0;
	}
}
