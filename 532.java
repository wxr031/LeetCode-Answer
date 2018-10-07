class Solution {
	public int findPairs(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>();
		int total = 0;
		if(k == 0) {
			HashSet<Integer> been = new HashSet<>();
			for(int num : nums) {
				if(!been.contains(num)) {
					if(set.contains(num)) {
						total++;
						been.add(num);
					}
					else {
						set.add(num);
					}
				}
			}
		}
		else if(k > 0) {
			for(int num : nums) {
				set.add(num);
			}
			for(int num : set) {
				if(set.contains(num + k)) {
					total++;
				}
			}
		}
		return total;
	}
}

