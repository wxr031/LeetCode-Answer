class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] dists = new int[6];
		dists[0] = dist(p1, p2);
		dists[1] = dist(p1, p3);
		dists[2] = dist(p1, p4);
		dists[3] = dist(p2, p3);
		dists[4] = dist(p2, p4);
		dists[5] = dist(p3, p4);
		Arrays.sort(dists);
		if (dists[0] == 0)
			return false;
		for (int i = 0; i < 4; i++) {
			if (dists[i] != dists[0])
				return false;
		}
		for (int i = 5; i < 6; i++) {
			if (dists[i] != dists[0] * 2)
				return false;
		}
		return true;
	}
	private int dist(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}
}
