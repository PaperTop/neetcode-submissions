class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] minDist = new int[points.length];
        for (int i = 0; i < minDist.length; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[points.length];
        
        int cost = 0;
        visited[0] = true;
        minDist[0] = 0;
        
        int[] curPoint = points[0];

        for (int i = 1; i < points.length; i++) {
            int curMinIdx = -1;
            for (int j = 0; j < points.length; j++) {
                if (!visited[j]) {
                    int newDist = Math.abs(curPoint[0] - points[j][0]) + Math.abs(curPoint[1] - points[j][1]);
                    minDist[j] = Math.min(minDist[j], newDist);
                    curMinIdx = curMinIdx == -1 ? j : minDist[j] < minDist[curMinIdx] ? j : curMinIdx;
                }
            }
            cost += minDist[curMinIdx];
            curPoint = points[curMinIdx];
            visited[curMinIdx] = true;
        }

        return cost;
    }
}
