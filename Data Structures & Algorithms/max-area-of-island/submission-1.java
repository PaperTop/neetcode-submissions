//optimizations
class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    res = Math.max(res, bfs(grid, row, col));
                }  
            }  
        }
        return res;
    }

    private int bfs(int[][] grid, int row, int col) {
        int res = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] dir : directions) {
                int newRow = point[0] + dir[0], newCol = point[1] + dir[1];
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                    res++;
                }
            }
        }
        return res;
    } 
}
