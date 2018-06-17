class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] result = new int[Math.min(nums1.length, nums2.length)];
		int top = 0;
		for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if(nums1[i] == nums2[j]) {
				result[top++] = nums1[i];
				i++;
				j++;
			}
			else if(nums1[i] < nums2[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		return Arrays.copyOfRange(result, 0, top);
	}
}
