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
	public int eraseOverlapIntervals(Interval[] intervals) {
		Arrays.sort(intervals, (int1, int2) -> (int1.end - int2.end));
		int maximum = 0, prevEnd = Integer.MIN_VALUE;
		for(Interval interval : intervals) {
			if(interval.start >= prevEnd) {
				maximum++;
				prevEnd = interval.end;
			}
		}
		return intervals.length - maximum;
	}
}
