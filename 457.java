class Solution {
	public boolean circularArrayLoop(int[] nums) {
		byte[] been = new byte[nums.length];
		for(int start = 0; start < nums.length; start++) {
			if(been[start] != -1) {
				int trace = start;
				while(been[trace] == 0 && (nums[start] > 0) == (nums[trace] > 0)) {
					been[trace] = 1;
					trace = (trace + nums[trace]) % nums.length;
					if(trace < 0) trace += nums.length;
				}
				if(been[trace] == 1 && nums[trace] % nums.length != 0) {
					return true;
				}
				else {
					int i = start;
					while(i != trace) {
						been[i] = -1;
						i = (i + nums[i]) % nums.length;
						if(i < 0) i += nums.length;
					}
				}
			}
		}
		return false;
	}
}
