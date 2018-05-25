class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] aux = new int[nums.length];
		int temp = 1;
		for(int i = 0 ; i < nums.length; i++) {
			aux[i] = temp;
			temp *= nums[i];
		}
		temp = 1;
		for(int i = nums.length-1; i >= 0; i--) {
			aux[i] *= temp;
			temp *= nums[i];
		}
		return aux;
	}
}
