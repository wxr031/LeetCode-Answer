import java.util.*;

class Solution {
	public static int getPivot(int[] nums, int k) {
		int pivot_pos = (int)(Math.random() * nums.length), pivot = nums[pivot_pos];
		int temp;
		
		// swap pivot and nums[0]
		temp = nums[pivot_pos];
		nums[pivot_pos] = nums[0];
		nums[0] = temp;

		int lastPos = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] < pivot) {
				lastPos++;
				// swap nums[i] and nums[j]
				temp = nums[i];
				nums[i] = nums[lastPos];
				nums[lastPos] = temp;
			}
		}
		// swap temp and nums[0]
		temp = nums[0];
		nums[0] = nums[lastPos];
		nums[lastPos] = temp;

		return lastPos;
	}
	public static int findKthLargest(int[] nums, int k) {
		int pivotPos = getPivot(nums, k);
		if(pivotPos > k-1) {
			return findKthLargest(Arrays.copyOfRange(nums, 0, pivotPos), k);
		}
		else if (pivotPos < k-1){
			return findKthLargest(Arrays.copyOfRange(nums, pivotPos+1, nums.length), k-pivotPos-1);
		}
		else {
			return nums[pivotPos];
		}
	}
	public static void main(String args[]) {
		int[] nums= new int[] {7, 2, 5, 1, 6, 3, 9, 8};
		int k = 8;
		System.out.println(findKthLargest(nums, k));
	}
}
