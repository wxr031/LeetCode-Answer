import java.util.*;
class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();
		if(s.length() <= 10) return result;
		int[] dna = new int[128];
		dna['A'] = 0;
		dna['T'] = 1;
		dna['G'] = 2;
		dna['C'] = 3;
		int key = 0, curr = 0, mask = 0x3ffff;
		for(int i = 0; i < 10; i++) {
			key = (key << 2) | dna[s.charAt(i)];
			curr = (curr << 2) | dna[s.charAt(i)];
		}
		byte[] contain = new byte[1 << 20];
		contain[key] = 1;
		for(int i = 10; i < s.length(); i++) {
			key = ((key & mask) << 2) | dna[s.charAt(i)];
			if(contain[key] == 0) {
				contain[key] = 1;
			}
			else if(contain[key] == 1) {
				result.add(s.substring(i-9, i+1));
				contain[key] = -1;
			}
		}
		return result;
	}
}
