class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		restoreIpAddressesUtil(result, s, sb, 4);
		return result;
	}
	private void restoreIpAddressesUtil(List<String> result, String s, StringBuilder sb, int remain) {
		if(remain == 0) {
			if(s.length() == 0) {
				sb.deleteCharAt(sb.length()-1);
				result.add(sb.toString());
			}
			return;
		}
		int last = sb.length();
		sb.append(".");
		if(s.length() > 0) {
			sb.insert(sb.length()-1, s.charAt(0));
			restoreIpAddressesUtil(result, s.substring(1), sb, remain-1);
			if(s.charAt(0) == '0') {
				sb.delete(last, sb.length());
				return;
			}
		}
		if(s.length() > 1) {
			sb.insert(sb.length()-1, s.charAt(1));
			restoreIpAddressesUtil(result, s.substring(2), sb, remain-1);
		}
		if(s.length() > 2 && (s.charAt(0) == '1' || ( s.charAt(0) == '2' && (s.charAt(1) <= '4'
							|| (s.charAt(1) == '5' && (s.charAt(2) <= '5')))))) {
			sb.insert(sb.length()-1, s.charAt(2));
			restoreIpAddressesUtil(result, s.substring(3), sb, remain-1);
		}
		sb.delete(last, sb.length());
	}
}
