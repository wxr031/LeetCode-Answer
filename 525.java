class Solution {
	public int findMaxLength(int[] nums) {
		int[] aux = new int[2 * nums.length + 1];
		Arrays.fill(aux, -1);
		aux[nums.length] = 0;
		int sum = 0, result = 0;
		for(int i = 1; i <= nums.length; i++) {
			sum += (nums[i - 1] == 0 ? -1 : 1);
			int index = nums.length + sum;
			if(aux[index] == -1) aux[index] = i;
			result = Math.max(i - aux[index], result);
		}
		return result;
	}
}
