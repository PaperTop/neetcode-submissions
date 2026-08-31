//Scenarios
//1: insert cleanly
//2: merge
    //Track which values to update to
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
                if (startIdx == -1) {
                    startIdx = i; // First overlap
                }
                endIdx = i;       // Keep updating until last overlap
            }
        }
        
        if (startIdx == -1) {
            int insertPos = n;
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] > newInterval[0]) {
                    insertPos = i;
                    break;
                }
            }

            int[][] res = new int[n + 1][2];
            int resIdx = 0;
            
            for (int i = 0; i < insertPos; i++) {
                res[resIdx++] = intervals[i];
            }
            res[resIdx++] = newInterval;
            for (int i = insertPos; i < n; i++) {
                res[resIdx++] = intervals[i];
            }
            return res;
        }


        int[][] res = new int[n - endIdx + startIdx][2];
        int resIdx = 0;

        int newStart = Math.min(newInterval[0], intervals[startIdx][0]);
        int newEnd = Math.max(newInterval[1], intervals[endIdx][1]);

        for (int i = 0; i < startIdx; i++) {
            res[resIdx++] = intervals[i];
        }

        res[startIdx] = new int[]{newStart, newEnd};
        resIdx++;

        for (int i = endIdx + 1; i < n; i++) {
            res[resIdx++] = intervals[i];
        }

        return res;
    }
}
