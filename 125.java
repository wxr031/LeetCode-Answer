class Solution {
	public boolean isPalindrome(String s) {
		String filter = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		return filter.equals(new StringBuilder(filter).reverse().toString());
	}
}
