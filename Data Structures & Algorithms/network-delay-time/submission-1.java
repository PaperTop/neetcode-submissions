class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n]; //stores all the closest distancese
        Arrays.fill(dist, Integer.MAX_VALUE); //initially fill with max values
        dist[k - 1] = 0; //set start node start to 0

        for (int i = 0; i < n - 1; i++) { //iterate over each node
            for (int[] time : times) { //for each node check all times
                int u = time[0] - 1, v = time[1] - 1, w = time[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        int maxDist = Arrays.stream(dist).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}
