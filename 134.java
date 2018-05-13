class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for(int i = 0; i < gas.length; i++) {
			gas[i] -= cost[i];
		}
		int left = 0, right = 0, total = gas[0];
		while(right + 1 != left && (left != 0 || right != gas.length-1)) {
			if(total >= 0) {
				right = (right == gas.length-1) ? 0 : right+1;
				total += gas[right];
			}
			else {
				left = (left == 0) ? gas.length-1 : left-1;
				total += gas[left];
			}
		}
		return (total < 0) ? -1 : left;
	}
}
