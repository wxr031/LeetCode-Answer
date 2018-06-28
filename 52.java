class Solution {
	public int totalNQueens(int num) {
		boolean[] row = new boolean[num];
		boolean[] rightDiagnal = new boolean[num*2-1];
		boolean[] leftDiagnal = new boolean[num*2-1];
		int[] putRow = new int[num];
		return totalNQueensUtil(num, row, leftDiagnal, rightDiagnal, putRow, 0, 0);
	}
	private int totalNQueensUtil(int num, boolean[] row, boolean[] leftDiagnal,
			boolean[] rightDiagnal, int[] putRow, int pos, int result) {
		if(pos == num) return result+1;
		for(int i = 0; i < num; i++) {
			if(!row[i] && !leftDiagnal[i+pos] && !rightDiagnal[i-pos+num-1]) {
				putRow[pos] = i;
				row[i] = leftDiagnal[i+pos] = rightDiagnal[i-pos+num-1] = true;
				result = totalNQueensUtil(num, row, leftDiagnal, rightDiagnal, putRow, pos+1, result);
				row[i] = leftDiagnal[i+pos] = rightDiagnal[i-pos+num-1] = false;
			}
		}
		return result;
	}
}
