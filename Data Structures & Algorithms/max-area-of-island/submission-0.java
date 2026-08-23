class Solution {
    Set<String> visited;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new HashSet<>();
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !visited.contains(row + "," + col)) {
                    res = Math.max(res, bfs(grid, row, col));
                }  
            }  
        }
        return res;
    }

    private int bfs(int[][] grid, int row, int col) {
        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            //check current point and leave early if bad
            if (point[0] < 0 || point[0] >= grid.length || point[1] < 0 || point[1] >= grid[0].length || visited.contains(point[0] + "," + point[1]) || grid[point[0]][point[1]] == 0) {
                continue;
            }
            //add to hashset
            visited.add(point[0] + "," + point[1]);
            res++;
            //add up left down right
            queue.add(new int[]{point[0] - 1, point[1]});
            queue.add(new int[]{point[0], point[1] - 1});
            queue.add(new int[]{point[0] + 1, point[1]});
            queue.add(new int[]{point[0], point[1] + 1});
        }
        return res;
    } 
}
