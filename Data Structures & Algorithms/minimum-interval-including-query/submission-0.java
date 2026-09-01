class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] output = new int[queries.length]; //store solution
        
        //sorting intervals and queries with original indices
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int itvIdx = 0;
        for (int i = 0; i < sortedQueries.length; i++) {

            while (itvIdx < intervals.length && intervals[itvIdx][0] <= sortedQueries[i][0]) {
                minHeap.offer(new int[]{intervals[itvIdx][1] - intervals[itvIdx][0] + 1, intervals[itvIdx][1]});
                itvIdx++;
            }
            //Remove expired intervals from the top.
            while (!minHeap.isEmpty() && minHeap.peek()[1] < sortedQueries[i][0]) {
                minHeap.poll();
            }
            
            //Add answer
            if (minHeap.isEmpty()) {
                output[sortedQueries[i][1]] = -1;
            } else {
                int answer = minHeap.peek()[0];
                output[sortedQueries[i][1]] = answer;
            }
        }
        
        return output;
    }
}
