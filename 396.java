class Solution {
	public int maxRotateFunction(int[] array) {
		int f = 0, total = 0;
		for(int i = 0; i < array.length; i++) {
			f += i * array[i];
			total += array[i];
		}
		int result = f;
		for(int i = 1; i < array.length; i++) {
			f += total - array.length * array[array.length - i];
			result = Math.max(result, f);
		}
		return result;
	}
}
