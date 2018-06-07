class Solution {
	public int maximumSwap(int num) {
		int[] index = new int[10];
		StringBuilder sb = new StringBuilder(Integer.toString(num));
		for(int i = 0; i < sb.length(); i++) {
			index[sb.charAt(i) - '0'] = i;  
		}
		for(int i = 0; i < sb.length(); i++) {
			for(int j = 9; j > sb.charAt(i) - '0'; j--) {
				if(index[j] > i) {
					char temp = sb.charAt(i);
					sb.setCharAt(i, sb.charAt(index[j]));
					sb.setCharAt(index[j], temp);
					return Integer.parseInt(sb.toString());
				}
			}
		}
		return Integer.parseInt(sb.toString());
	}
}
