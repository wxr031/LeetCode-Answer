ass Solution {
	public String optimalDivision(int[] nums) {
		if(nums.length == 0) return "";
		if(nums.length == 1) return String.valueOf(nums[0]);
		if(nums.length == 2) return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(nums[0]));
		sb.append("/(");
		for(int i = 1; i < nums.length; i++) {
			sb.append(String.valueOf(nums[i]));
			sb.append("/");
		}
		sb.setCharAt(sb.length() - 1, ')');
		return sb.toString();
	}
}
