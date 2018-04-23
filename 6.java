class Solution {
	public String convert(String string, int numRows) {
		if(numRows == 1 || string == null || string.length() == 0) return string;
		StringBuilder builder = new StringBuilder();
		int width = numRows * 2 - 2;

		// first row
		for(int i = 0; i < string.length(); i += width) {
			builder.append(string.charAt(i));
		}

		// middle rows
		for(int k = 1; k < numRows-1; k++) {
			for(int i = k; i < string.length(); i += width) {
				builder.append(string.charAt(i));
				int zigZag = i + width - 2 * k;
				if(zigZag < string.length()) {
					builder.append(string.charAt(zigZag));
				}
			}
		}

		// last row
		for(int i = numRows-1; i < string.length(); i += width) {
			builder.append(string.charAt(i));
		}
		return builder.toString();
	}
}
