class Solution {
    public int reversePairs(int[] nums) {
        int[] aux = new int[nums.length];
        return reversePairsUtil(nums, aux, 0, nums.length - 1);
    }
    private int reversePairsUtil(int[] nums, int[] aux, int left, int right) {
        if(left >= right) return 0;
        int half = left + ((right - left) >> 1), result = 0;
        result += reversePairsUtil(nums, aux, left, half);
        result += reversePairsUtil(nums, aux, half + 1, right);
        for(int i = half + 1; i <= right; i++) {
            result += upperBound(nums, left, half, 2L * nums[i]);
        }
        merge(nums, aux, left, half, right);
        return result;
    }
    private int upperBound(int[] nums, int left, int right, long search) {
        if(search < nums[left]) return right - left + 1;
        if(search >= nums[right]) return 0;
        int rightTemp = right;
        while(left < right) {
            int half = left + ((right - left) >> 1);
            if(nums[half] <= search) left = half + 1;
            else right = half;
        }
        return rightTemp - left + 1;
    }
    private void merge(int[] nums, int[] aux, int left, int half, int right) {
        int now = left, headLeft = left, headRight = half, tailLeft = half + 1, tailRight = right;
        while(headLeft <= headRight && tailLeft <= tailRight) {
            if(nums[headLeft] < nums[tailLeft]) aux[now++] = nums[headLeft++];
            else aux[now++] = nums[tailLeft++];
        }
        while(headLeft <= headRight) aux[now++] = nums[headLeft++];
        while(tailLeft <= tailRight) aux[now++] = nums[tailLeft++];
        System.arraycopy(aux, left, nums, left, right - left + 1);
    }
}