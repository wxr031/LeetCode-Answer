class Solution {
	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		for(int hour = 0; hour < 12; hour++) {
			for(int minute = 0; minute < 60; minute++) {
				if(Integer.bitCount((minute << 4) + hour) == num) {
					result.add(hour + ":" + ((minute < 10) ? "0" : "") + minute);
				}
			}
		}
		return result;
	}
}
