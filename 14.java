class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		return divideAndConquer(strs, 0, strs.length-1);
	}
	public String divideAndConquer(String strs[], int low, int high) {
		if(low == high) return strs[low];
		int mid = (low + high) / 2;
		return twoLCP(divideAndConquer(strs, low, mid), divideAndConquer(strs, mid+1, high));
	}
	public String twoLCP(String substr1, String substr2) {
		if(substr1.length() == 0 || substr2.length() == 0 || substr1.charAt(0) != substr2.charAt(0))
			return "";
		int length = Math.min(substr1.length(), substr2.length());
		for(int pos = 0; pos < length; pos++) {
			if(substr1.charAt(pos) != substr2.charAt(pos)) {
				return substr1.substring(0, pos);
			}
		}
		return substr1.substring(0, length);
	}
}
