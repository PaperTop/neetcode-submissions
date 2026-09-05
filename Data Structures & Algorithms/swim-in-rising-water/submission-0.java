class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));
        boolean[][] visited = new boolean[grid.length][grid.length];
        int waterLvl = 0;
        
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        minHeap.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] next = minHeap.poll();
            int nextWater = grid[next[0]][next[1]];

            waterLvl = Math.max(waterLvl, nextWater);
            if (next[0] == grid.length - 1 && next[1] == grid.length - 1) {
                break;
            } else {
                for (int[] d : dir) {
                    int newX = next[0] + d[0], newY = next[1] + d[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length && !visited[newX][newY]) {
                        minHeap.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return waterLvl;
    }
}
