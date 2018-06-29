class Solution {
	public List<Integer> lexicalOrder(int num) {
		List<Integer> result = new ArrayList<>();
		int curr = 1;
		for(int i = 0; i < num; i++) {
			result.add(curr);
			if(curr * 10 <= num) {
				curr *= 10;
			}
			else if(curr == num || curr % 10 == 9) {
				curr /= 10;
                while(curr % 10 == 9) {
                    curr /= 10;
                }
                curr++;
			}
			else {
				curr++;
			}
		}
		return result;
	}
}

