class Solution {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] array1, int[] array2) {
				return array1[0] == array2[0] ? array1[1] - array2[1] : array2[0] - array1[0];
			}
		});
		List<int[]> list = new LinkedList<>();
		for(int[] now : people) {
			list.add(now[1], now);
		}
		return list.toArray(new int[people.length][2]);
	}
}
