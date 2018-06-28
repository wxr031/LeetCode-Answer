class Solution {
	public List<List<String>> solveNQueens(int num) {
		List<List<String>> result = new ArrayList<>();
		boolean[] row = new boolean[num];
		boolean[] rightDiagnal = new boolean[num*2-1];
		boolean[] leftDiagnal = new boolean[num*2-1];
		int[] putRow = new int[num];
		solveNQueensUtil(result, num, row, leftDiagnal, rightDiagnal, putRow, 0);
		return result;
	}
	private void solveNQueensUtil(List<List<String>> result, int num, boolean[] row,
			boolean[] leftDiagnal, boolean[] rightDiagnal, int[] putRow, int pos) {
		if(pos == num) {
			List<String> list = new ArrayList<>();
			for(int i = 0; i < num; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < putRow[i]; j++) sb.append('.');
				sb.append('Q');
				for(int j = putRow[i]+1; j < num; j++) sb.append('.');
				list.add(sb.toString());
			}
			result.add(list);
			return;
		}
		for(int i = 0; i < num; i++) {
			if(!row[i] && !leftDiagnal[i+pos] && !rightDiagnal[i-pos+num-1]) {
				putRow[pos] = i;
				row[i] = leftDiagnal[i+pos] = rightDiagnal[i-pos+num-1] = true;
				solveNQueensUtil(result, num, row, leftDiagnal, rightDiagnal, putRow, pos+1);
				row[i] = leftDiagnal[i+pos] = rightDiagnal[i-pos+num-1] = false;
			}
		}
	}
}
