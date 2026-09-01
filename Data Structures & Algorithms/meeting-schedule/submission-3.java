/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // 1. Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // 2. Compare adjacent intervals starting from index 1
        for (int i = 1; i < intervals.size(); i++) {
            // Next meeting starts before the previous one ends
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }
}
