public class Solution {
	public int findMaximizedCapital(int project, int capital, int[] profits, int[] capitals) {
		PriorityQueue<Integer> profitPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<int[]> capitalPq = new PriorityQueue<>((arr1, arr2) -> {return arr1[0] - arr2[0];});
		for (int i = 0; i < profits.length; i++) {
			capitalPq.offer(new int[] {capitals[i], profits[i]});
		}
		while(project-- > 0) {
			while(!capitalPq.isEmpty() && capitalPq.peek()[0] <= capital) {
				profitPq.offer(capitalPq.poll()[1]);
			}
			if(profitPq.isEmpty())
				break;
			capital += profitPq.poll();
		}
		return capital;
	}
}
