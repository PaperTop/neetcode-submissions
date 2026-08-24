class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    q.add(new int[]{row, col});
                }
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];
            for (int[] d : dir) {
                int newR = row + d[1], newC = col + d[0];
                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] > grid[row][col] + 1) {
                    q.add(new int[]{newR, newC});
                    grid[newR][newC] = grid[row][col] + 1;
                }
            }
        }
    }
}
