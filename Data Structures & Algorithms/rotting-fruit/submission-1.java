//Multi source BFS. Fresh banana counter. if fresh > 0 then return -1 else max time
//Clean up improvements
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                int row = point[0], col = point[1];

                for (int[] d : dir) {
                    int newR = row + d[0], newC = col + d[1];
                    if (newR >= 0 && newR < grid.length 
                        && newC >= 0 && newC < grid[0].length 
                        && grid[newR][newC] == 1) {

                        q.offer(new int[]{newR, newC});
                        grid[newR][newC] = 2;
                        fresh--;
                    }
                }
            }
            res++;
        }

        return fresh > 0 ? -1 : Math.max(0, res - 1);
    }
}
