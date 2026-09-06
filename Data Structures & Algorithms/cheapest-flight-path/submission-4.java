class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        dist[src][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, src, 0}); // 0: cost 1:city 2:stops

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int cost = cur[0];
            int city = cur[1];
            int stops = cur[2];
            if (city == dst) {
                return cost;                
            }
            if (stops == k + 1|| dist[city][stops] < cost) {
                continue;
            }
            for (int[] ad : adj[city]) {
                int nextCity = ad[0];
                int nextCost = cost + ad[1];
                int nextStop = stops + 1;
                if (dist[nextCity][nextStop] > nextCost) {
                    dist[nextCity][nextStop] = nextCost;
                    minHeap.offer(new int[]{nextCost, nextCity, nextStop});
                }
            }
        }

        return -1;
    }
}
