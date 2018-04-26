/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) return result;
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval inter1, Interval inter2) {
				return inter1.start - inter2.start;
			}
		});
        int prevStart = intervals.get(0).start, prevEnd = intervals.get(0).end;
		for(int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).start > prevEnd) {
				result.add(new Interval(prevStart, prevEnd));
				prevStart = intervals.get(i).start;
				prevEnd = intervals.get(i).end;
			}
            else if(intervals.get(i).end > prevEnd) {
				prevEnd = intervals.get(i).end;
			}
		}
		result.add(new Interval(prevStart, prevEnd));
		return result;
	}
}

