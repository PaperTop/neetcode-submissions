class Solution {
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    for (int[] d : dir) {
                        dfs(grid, row + d[1], col + d[0], 1);
                    }   
                }
            }
        }
    }
    
    private void dfs(int[][] grid, int row, int col, int dis) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1 || grid[row][col] <= dis) {
            return;
        }

        grid[row][col] = Math.min(grid[row][col], dis);
        
        for (int[] d : dir) {
            dfs(grid, row + d[1], col + d[0], dis + 1);
        }    
    }
}
