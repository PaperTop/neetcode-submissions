/*Strategy: 
Idea 1: Can we peform BFS one each node and mark the longest position that node has been in? No we cannot because that would essentially be brute force where we're asking ourselves if this is the start
Idea 2: Think of each position as a node and try and go to the end and beginning of each block. Keep track of distance to see which is the farthest on higher end and lower end.
Idea 3: Run DFS on each node that will top down add the current length that it will be at. Then if we ever encounter that node again we can just add that to our current length and start going backward. Will need to keep track of a maximum length value. Will iterate through the matrix so will be nm time and worst case rubnning nm twice which is still nm
*/
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int res = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(memo, matrix, i, j));
            }
        }

        return res;
    }

    private int dfs(int[][] memo, int[][] matrix, int i, int j) {
        //memo
        if (memo[i][j] != -1) return memo[i][j];
        
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int res = 1;

        for (int[] d : dir) {
            int newX = i + d[0];
            int newY = j + d[1];
            if (newX >= 0 && newX < matrix.length && 
                newY >= 0 && newY < matrix[0].length && 
                matrix[newX][newY] > matrix[i][j]) {
                res = Math.max(res, 1 + dfs(memo, matrix, newX, newY));
            }
        }

        memo[i][j] = res;
        return memo[i][j];
    }
}
