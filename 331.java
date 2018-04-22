class Solution {
	public boolean isValidSerialization(String preorder) {
		int offset = 1;
		String[] separate = preorder.split(",");
		for(String sub : separate) {
			if(--offset < 0) return false;
			if(!sub.equals("#")) offset += 2;
		}
		return offset == 0;
	}
}
