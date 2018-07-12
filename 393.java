class Solution {
	public boolean validUtf8(int[] data) {
		for(int i = 0; i < data.length;) {
			if((data[i] & 0x80) != 0) {
				int oneBit = countOneBits(data[i]);
				if(oneBit == 1 || oneBit > 4 || !check10(data, i + 1, oneBit - 1)) {
					return false;
				}
				i += oneBit;
			}
			else i++;
		}
		return true;
	}
	private int countOneBits(int data) {
		int count = 0;
		for(int mask = 1 << 7; (data & mask) != 0; mask >>>= 1) count++;
		return count;
	}
	private boolean check10(int[] data, int begin, int num) {
		for(int i = 0; i < num; i++) {
			if(begin + i >= data.length || data[begin + i] >>> 6 != 2) {
				return false;
			}
		}
		return true;
	}
}
