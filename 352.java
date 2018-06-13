/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

	TreeMap<Integer,Interval> tree;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		tree = new TreeMap<>();
	}

	public void addNum(int val) {
		if(tree.containsKey(val)) return;
		Integer lowStart = tree.lowerKey(val), highStart = tree.higherKey(val);
		Interval low = lowStart == null ? null : tree.get(lowStart);
		Interval high = highStart == null ? null : tree.get(highStart);
		if(low != null && val <= low.end) return;
		if(low != null && low.end == val - 1 && high != null && high.start == val + 1) {
			tree.put(low.start, new Interval(low.start, high.end));
			tree.remove(high.start);
		}
		else if(low != null && low.end == val - 1) {
			tree.put(low.start, new Interval(low.start, val));
		}
		else if(high != null && high.start == val + 1) {
			tree.put(val, new Interval(val, high.end));
			tree.remove(high.start);
		}
		else {
			tree.put(val, new Interval(val, val));
		}
	}

	public List<Interval> getIntervals() {
		return new ArrayList<Interval>(tree.values());
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

