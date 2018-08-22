class Solution {
	public String validIPAddress(String IP) {
		int IPv4Split = IP.lastIndexOf('.'), IPv6Split = IP.lastIndexOf(':');
		/* special case: xxx.xxx.xxx.xxx. , we need to eliminate the special case
		   when there's a trailing '.' at the end of the string*/
		if(IPv4Split > 0 && IPv4Split < IP.length() - 1) {
			String[] decs = IP.split("\\.");
			if(decs.length == 4) {
				for(int i = 0; i < 4; i++) {
					int dec = 0;
					if(decs[i].length() != 0 && (decs[i].charAt(0) != '0' || decs[i].length() == 1)) {
						for(int j = 0; j < decs[i].length(); j++) {
							char c = decs[i].charAt(j);
							if(c >= '0' && c <= '9') {
								dec = dec * 10 + c - '0';
							}
							else return "Neither";
							if(dec >= 256) {
								return "Neither";
							}
						}
					}
					else return "Neither";
				}
				return "IPv4";
			}
		}
		/* special case: xxxx:xxxx:xxxx:xxxx:xxxx:xxxx:xxxx:xxxx: , we need to eliminate the special case
		   when there's a trailing ':' at the end of the string*/
		if(IPv6Split > 0 && IPv6Split < IP.length() - 1) {
			String[] hexs = IP.split(":");
			if(hexs.length == 8) {
				for(int i = 0; i < 8; i++) {
					if(hexs[i].length() <= 4 && hexs[i].length() > 0) {
						for(int j = 0; j < hexs[i].length(); j++) {
							char c = hexs[i].charAt(j);
							if((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
								return "Neither";
							}
						}
					}
					else return "Neither";
				}
				return "IPv6";
			}
		}
		return "Neither";
	}
}
