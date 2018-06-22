import java.util.*;
class Solution {
	public static int wiggleMaxLength(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int[] rise = new int[nums.length], sink = new int[nums.length];
		rise[0] = sink[0] = 1;
		int result = 1;
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					rise[i] = Math.max(rise[i], sink[j] + 1);
					sink[i] = Math.max(sink[i], sink[j]);
				}
				else if(nums[j] > nums[i]) {
					rise[i] = Math.max(rise[i], rise[j]);
					sink[i] = Math.max(sink[i], rise[j] + 1);
				}
			}
			result = Math.max(result, Math.max(sink[i], rise[i]));
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.print(rise[i] + (i == nums.length - 1 ? "\n" : " "));
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.print(sink[i] + (i == nums.length - 1 ? "\n" : " "));
		}
		return result;
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int[] nums = new int[length];
		for(int i = 0; i < length; i++) {
			nums[i] = scanner.nextInt();
		}
		System.out.println(wiggleMaxLength(nums));
	}
}
