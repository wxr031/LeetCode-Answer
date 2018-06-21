class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length <= 2) return 0;
		List<Map<Long, Long>> dp = new ArrayList<>();
		dp.add(new HashMap<Long,Long>());
		int result = 0;
		for(int i = 1; i < A.length; i++) {
			Map<Long,Long> diffMap = new HashMap<Long, Long>();
			for(int j = 0; j < i; j++) {
				long diff = (long)A[i] - A[j];
				if(dp.get(j).containsKey(diff)) {
					long diffNum = dp.get(j).get(diff);
					if(diffMap.containsKey(diff)) diffMap.put(diff, diffMap.get(diff) + diffNum + 1);
					else diffMap.put(diff, diffNum + 1L);
					result += diffNum;
				}
				else if(diffMap.containsKey(diff)) diffMap.put(diff, diffMap.get(diff) + 1);
				else diffMap.put(diff, 1L);
			}
			dp.add(diffMap);
		}
		return result;
	}
}

