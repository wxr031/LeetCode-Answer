class Solution {
	public int maxSumSubmatrix(int[][] matrix, int bound) {
		int length = matrix.length, width = matrix[0].length;
		int[][] prefix = new int[length][width + 1];
		for(int i = 0; i < length; i++) {
			for(int j = 1; j <= width; j++) {
				prefix[i][j] = prefix[i][j - 1] + matrix[i][j - 1];
			}
		}
		int[] temp = new int[length];
		int result = Integer.MIN_VALUE;
		for(int i = 1; i <= width; i++) {
			for(int j = i; j <= width; j++) {
				TreeSet<Integer> tree = new TreeSet<>();
				tree.add(0);
				int sum = 0;
				for(int k = 0; k < length; k++) {
					sum += prefix[k][j] - prefix[k][i-1];
					Integer upperBound = tree.higher(sum - bound - 1);
					if(upperBound != null) result = Math.max(result, sum - upperBound);
					tree.add(sum);
				}
			}
		}
		return result;
	}
}

