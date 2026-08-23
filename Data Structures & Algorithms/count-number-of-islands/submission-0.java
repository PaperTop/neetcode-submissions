//Strategy: Interate through each point. Hashset to keep which is tested. When find a point that has not been checked and is a 1 perform bfs in every direction and add those to the hashset.
class Solution {
    Set<String> clear;
    public int numIslands(char[][] grid) {
        clear = new HashSet<>();
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && !clear.contains(row + "," + col)) {
                    bfs(grid, row, col);
                    res++;
                }  
            }  
        }
        return res;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            //check current point and leave early if bad
            if (point[0] < 0 || point[0] >= grid.length || point[1] < 0 || point[1] >= grid[0].length || clear.contains(point[0] + "," + point[1]) || grid[point[0]][point[1]] == '0') {
                continue;
            }
            //add to hashset
            clear.add(point[0] + "," + point[1]);
            //add up left down right
            queue.add(new int[]{point[0] - 1, point[1]});
            queue.add(new int[]{point[0], point[1] - 1});
            queue.add(new int[]{point[0] + 1, point[1]});
            queue.add(new int[]{point[0], point[1] + 1});
        }
    } 
}
