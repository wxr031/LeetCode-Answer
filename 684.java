class Solution {
	public int[] findRedundantConnection(int[][] edges) {  
		DSU dsu = new DSU(edges.length);
		for(int[] edge : edges) {
			if(dsu.union(edge[0], edge[1])) {
				return edge;
			}
		}
		return null;
	}

	private class DSU {
		private int[] rank, prev;

		public DSU(int e) {
			rank = new int[e + 1];
			prev = new int[e + 1];
			Arrays.fill(prev, -1);
		}

		private int find(int n) {
			if(prev[n] == -1) return n;
			return prev[n] = find(prev[n]);
		}

		private boolean union(int n1, int n2) {
			int head1 = find(n1), head2 = find(n2);
			if(head1 == head2) {
				return true;
			}
			if(rank[head1] < rank[head2]) {
				prev[head1] = head2;
			}
			else if(rank[head1] > rank[head2]) {
				prev[head2] = head1;
			}
			else {
				prev[head2] = head1;
				rank[head1]++;
			}
			return false;
		}
	}
}
