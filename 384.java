class Solution {

	private int[] copy;
	Random random;

	public Solution(int[] nums) {
		copy = Arrays.copyOf(nums, nums.length);
		random = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return Arrays.copyOf(copy, copy.length);
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] shuffleArray = Arrays.copyOf(copy, copy.length);
		for(int j = copy.length - 1; j >= 0; j--) {
			swap(shuffleArray, random.nextInt(j + 1), j);
		}
		return shuffleArray;
	}

	private void swap(int[] shuffleArray, int i, int j) {
		int temp = shuffleArray[i];
		shuffleArray[i] = shuffleArray[j];
		shuffleArray[j] = temp;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

