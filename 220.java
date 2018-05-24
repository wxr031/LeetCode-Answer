import java.util.*;
class Solution {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Map<Integer,Long> map = new HashMap<>();
		for(int i = 0; i < k; i++) {
			int bucketId = nums[i] / (t+1);
			if(map.containsKey(bucketId)
					|| (map.containsKey(bucketId-1) && (long)nums[i] - map.get(bucketId-1) <= t)
					|| (map.containsKey(bucketId+1) && (long)map.get(bucketId+1) - nums[i] <= t)) {
				return true;
			}   
			map.put(bucketId, (long)nums[i]);
		}   
		for(int i = k; i < nums.length; i++) {
			int bucketId = nums[i] / (t+1);
			if(map.containsKey(bucketId)
					|| (map.containsKey(bucketId-1) && (long)nums[i] - map.get(bucketId-1) <= t)
					|| (map.containsKey(bucketId+1) && (long)map.get(bucketId+1) - nums[i] <= t)) {
				return true;
			}   
			int lastBucketId = nums[i-k] / (t+1);
			map.remove(lastBucketId);
			map.put(bucketId, (long)nums[i]);
		}
		return false;
	}
	public static void main(String args[]) {
		int[] nums = new int[] {-2147483647, -2147483648, 2012909090, 2147483647, 2147483646};
		int k = 2;
		int t = 0;
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
	}
}
