//BFS
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
           map.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int maxTime = -1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[]{k, 0});
        
        while (!minHeap.isEmpty()) {
            int curNode = minHeap.peek()[0];
            int curLength = minHeap.poll()[1];
            if (visited.contains(curNode)) {
                continue;
            }
            //update itself
            visited.add(curNode);
            n--;
            maxTime = Math.max(maxTime, curLength);

            //continue growing
            for (int[] pointer : map.get(curNode)) {
                minHeap.offer(new int[]{pointer[0], pointer[1] + curLength});
            }
        }

        return n > 0 ? -1 : maxTime;
    }
}
