class Solution {
	public int magicalString(int num) {
		if(n <= 0) return 0;
		if(n == 1) return 1;
		int left = 0, right = 0, put, count = 0;
		int[] array = new int[num];
		array[0] = 1;
		array[1] = 2;
		while(right < num) {
			for(int i = 0; i < array[left] && right < num; i++) {
				array[right++] = put;
				if(put == 1) count++;
			}
			put ^= 3;
			left++;
		}
		return count;
	}
}
