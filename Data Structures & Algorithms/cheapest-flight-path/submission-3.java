class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // cheapest[i] = cheapest cost to reach city i
        // using at most the number of flights allowed so far
        int[] cheapest = new int[n];
        Arrays.fill(cheapest, Integer.MAX_VALUE);
        cheapest[src] = 0;

        // k stops means at most k + 1 flights
        for (int flightsUsed = 0; flightsUsed <= k; flightsUsed++) {
            // Copy so this round can only add ONE additional flight
            int[] next = Arrays.copyOf(cheapest, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                // Can't take this flight if 'from' isn't reachable yet
                if (cheapest[from] == Integer.MAX_VALUE) {
                    continue;
                }

                // Try reaching 'to' through 'from'
                next[to] = Math.min(next[to], cheapest[from] + cost);
            }

            cheapest = next;
        }

        return cheapest[dst] == Integer.MAX_VALUE ? -1 : cheapest[dst];
    }
}