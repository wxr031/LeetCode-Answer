class Solution {
	public boolean isRectangleCover(int[][] rectangles) {
		if(rectangles == null || rectangles.length == 0)
			return true;
		int totalArea = 0;
		int[] bigRec = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE,
			Integer.MIN_VALUE, Integer.MIN_VALUE};
		Map<String,Boolean> map = new HashMap<>();
		for(int[] rec : rectangles) {
			if(rec[0] < bigRec[0]) bigRec[0] = rec[0];
			if(rec[1] < bigRec[1]) bigRec[1] = rec[1];
			if(rec[2] > bigRec[2]) bigRec[2] = rec[2];
			if(rec[3] > bigRec[3]) bigRec[3] = rec[3];
			totalArea += (rec[3] - rec[1]) * (rec[2] - rec[0]);
			addPoints(map, rec);
		}
		addPoints(map, bigRec);
		int wholeArea = (bigRec[2] - bigRec[0]) * (bigRec[3] - bigRec[1]);
		if(wholeArea != totalArea) return false;
		for(Map.Entry<String,Boolean> entry : map.entrySet()) {
			if(!entry.getValue()) return false;
		}
		return true;
	}
	private void addPoints(Map<String,Boolean> map, int[] rec) {
		String[] point = new String[] {rec[0] + "," + rec[1], rec[2] + "," + rec[3],
			rec[0] + "," + rec[3], rec[2] + "," + rec[1]};
		for(int i = 0; i < 4; i++) {
			if(map.containsKey(point[i])) map.put(point[i], !map.get(point[i]));
			else map.put(point[i], false);
		}
	}
}
