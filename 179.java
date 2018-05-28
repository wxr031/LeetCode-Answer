import java.util.Comparator;

class Solution {
    class Compare implements Comparator<String> {
	    public int compare(String string1, String string2) {
            String temp = new String(string2);
    		string1 += string2;
	    	string2 += temp;
	    	return string2.compareTo(string1);
	    }
    }
	public String largestNumber(int[] nums) {
        if(nums.length == 0) return "";
		String stringNums[] = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			stringNums[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(stringNums, new Compare());
		StringBuilder sb = new StringBuilder();
        for(String string : stringNums) {
            sb.append(string);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
	}
}
