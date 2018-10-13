class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for(int curr = 0; curr < nums.length; curr++) {
			sum += nums[curr];
			if(k != 0) sum %= k;
			if(map.containsKey(sum)) {
				if(map.get(sum) + 1 < curr)
					return true;
			}
			else {
				map.put(sum, curr);
			}
		}
		return false;
	}
}

