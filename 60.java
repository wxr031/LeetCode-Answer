class Solution {
	public String getPermutation(int n, int k) {
		if(n == 0 || k <= 0) return ""; 
		int factorial = 1;
		List<Integer> list = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			factorial *= i;
			list.add(i);
		}
		if(k > factorial) return "";
		k--; // make index start at 0
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			factorial /= n;
			int pos = k / factorial;
			sb.append((char)(list.get(pos)+'0'));
			list.remove(pos);
			k %= factorial;
			n--;
		}
		return sb.toString();
	}
}
