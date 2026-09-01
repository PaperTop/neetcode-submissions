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
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> times = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            times.add(new int[]{intervals.get(i).start, 1});
            times.add(new int[]{intervals.get(i).end, -1});
        } 

        //sort by times, if identical times sort by start going first then end
        times.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0, count = 0;
        for (int i = 0; i < times.size(); i++) {
            count += times.get(i)[1];
            res = Math.max(res, count);
        }

        return res;
    }
}
