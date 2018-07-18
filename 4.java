class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int size1 = nums1.length, size2 = nums2.length;
		int totalSize = size1 + size2, halfSize = totalSize / 2;
		if((totalSize & 1) == 1) {
			return (double) findKthUtil(nums1, nums2, size1, size2, halfSize);
		} else {
			return (double)(findKthUtil(nums1, nums2, size1, size2, halfSize - 1)
					+ findKthUtil(nums1, nums2, size1, size2, halfSize)) / 2;
		}
	}
	private int findKthUtil(int[] nums1, int[] nums2, int len1, int len2, int k) {
		if(len1 <= 0) return nums2[k];
		if(len2 <= 0) return nums1[k];
		int mid1 = len1 / 2, mid2 = len2 / 2;
		if(k <= mid1 + mid2) {
			if(nums1[mid1] < nums2[mid2]) {
				return findKthUtil(nums1, nums2, len1, mid2, k);
			}
			else {
				return findKthUtil(nums1, nums2, mid1, len2, k);
			}
		}
		else {
			if(nums1[mid1] < nums2[mid2]) {
				return findKthUtil(Arrays.copyOfRange(nums1, mid1+1, len1), nums2, len1-mid1-1, len2, k-mid1-1);
			}
			else {
				return findKthUtil(nums1, Arrays.copyOfRange(nums2, mid2+1, len2), len1, len2-mid2-1, k-mid2-1);
			}
		}
	}
}
