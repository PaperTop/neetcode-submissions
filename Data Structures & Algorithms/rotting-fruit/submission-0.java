//Multi source BFS. Fresh banana counter. if fresh > 0 then return -1 else max time
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c, 0});
                }
            }
        }

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int res = 0;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for (int[] d : dir) {
                int newR = row + d[0], newC = col + d[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] != 0 && grid[newR][newC] != 2) {
                    q.offer(new int[]{newR, newC, point[2] + 1});
                    res = Math.max(res, point[2] + 1);
                    grid[newR][newC] = 0;
                    fresh--;
                }
            }
        }

        if (fresh > 0) {
            return -1;
        }
        return res;
    }
}
