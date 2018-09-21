class Solution {
	public int findMinMoves(int[] machines) {
		int sum = 0;
		for(int machine : machines) {
			sum += machine;
		}
		if(sum % machines.length != 0) {
			return -1;
		}
		int num = sum / machines.length, move = 0;
		int result = 0;
		for(int machine : machines) {
			int diff = machine - num;
			move += diff;
			result = Math.max(result, Math.max(Math.abs(move), diff));
		}
		return result;
	}
}
