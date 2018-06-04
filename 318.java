class Solution {
	public int maxProduct(String[] words) {
		int[] nums = new int[words.length], length = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			length[i] = words[i].length();
			for(char c : words[i].toCharArray()) {
				nums[i] |= (1 << (c - 'a'));
			}
		}
		int result = 0;
		for(int i = 0; i < words.length - 1; i++)
			for(int j = i + 1; j < words.length; j++)
				if((nums[i] & nums[j]) == 0)
					result = Math.max(result, length[i] * length[j]);
		return result;
	}
}
