class Solution {
	public int maximumGap(int[] nums) {
		// base case
		if(nums.length <= 1) return 0;
		
		// find the maximum and minimum value of the array
		int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
		for(int num : nums) {
			if(num > maxNum) maxNum = num;
			if(num < minNum) minNum = num;
		}
		// If all numbers are the same, the answer is zero
		if(maxNum == minNum) return 0;
		
		// minimum possible capacity of the bucket
		int capacity = Math.max(1, (maxNum-minNum) / (nums.length-1));

		// determine the number of buckets
		int bucketNum = (maxNum-minNum) / capacity + 1;

		// put numbers into bucket
		// we only need to remember the maximum and minimum value in the bucket
		int[][] buckets = new int[2][bucketNum];
		Arrays.fill(buckets[0], Integer.MAX_VALUE);
		Arrays.fill(buckets[1], Integer.MIN_VALUE);
		for(int num : nums) {
			int index = (num - minNum) / capacity;
			if(num < buckets[0][index]) buckets[0][index] = num;
			if(num > buckets[1][index]) buckets[1][index] = num;
		}
		
		// find maximum bucket
		int result = -1;
		for(int i = 0, j; i < bucketNum-1; i = j) {
			j = i + 1;
			while(buckets[0][j] == Integer.MAX_VALUE) j++;
			result = Math.max(result, buckets[0][j] - buckets[1][i]);
		}
		return result;
	}
}
