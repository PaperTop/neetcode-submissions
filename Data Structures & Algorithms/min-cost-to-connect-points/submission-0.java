/*
Strategy: global minHeap with all the points, 
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                minHeap.offer(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j});
            }
        }

        int[] parents = new int[points.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int groups = parents.length;
        int cost = 0;
        while (groups != 1) {
            int[] item = minHeap.poll();
            int rootA = findRoot(parents, item[1]);
            int rootB = findRoot(parents, item[2]);
            if (rootA == rootB) {
                continue;
            } else {
                cost += item[0];
                groups--;
                parents[rootB] = rootA;
            }
        }

        return cost;
    }

    private int findRoot(int[] parents, int point) {
        while (parents[point] != point) {
            parents[point] = parents[parents[point]];
            point = parents[point];
        }

        return point;
    }
}
