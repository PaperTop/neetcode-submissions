//Strategy: 
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        // Sorting is mandatory for this linear scan strategy
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] curEnd = res.get(res.size() - 1);
            if (curEnd[0] <= intervals[i][1] && curEnd[1] >= intervals[i][0] ) {
                curEnd[0] = Math.min(curEnd[0], intervals[i][0]);
                curEnd[1] = Math.max(curEnd[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
