//See which positions pacific seeps to, see which position Atlantic seeps to and check which overlaps
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        //For pacific
        for (int i = 0; i < heights[0].length; i++) {
            pacific[0][i] = true;
            q.offer(new int[]{0, i});
        }
        for (int i = 1; i < heights.length; i++) {
            pacific[i][0] = true;
            q.offer(new int[]{i, 0});
        }
        while (!q.isEmpty()) {
            int[] pt = q.poll();
            int r = pt[0], c = pt[1];

            for (int[] d : dir) {
                int newR = r + d[0], newC = c + d[1];
                //check that the next step is within bounds and is also higher or equal
                if (newR >= 0 && newR < heights.length
                    && newC >= 0 && newC < heights[0].length
                    && !pacific[newR][newC] && heights[newR][newC] >= heights[r][c]) {
                    
                    pacific[newR][newC] = true;
                    q.offer(new int[]{newR, newC});        
                }
            }

        }



        for (int i = 0; i < heights[0].length; i++) {
            atlantic[heights.length - 1][i] = true;
            q.offer(new int[]{heights.length - 1, i});
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            atlantic[i][heights[0].length - 1] = true;
            q.offer(new int[]{i, heights[0].length - 1});
        }
        while (!q.isEmpty()) {
            int[] pt = q.poll();
            int r = pt[0], c = pt[1];

            for (int[] d : dir) {
                int newR = r + d[0], newC = c + d[1];
                //check that the next step is within bounds and is also higher or equal
                if (newR >= 0 && newR < heights.length
                    && newC >= 0 && newC < heights[0].length
                    && !atlantic[newR][newC] &&heights[newR][newC] >= heights[r][c]) {
                    
                    atlantic[newR][newC] = true;
                    q.offer(new int[]{newR, newC});        
                }
            }
        }
        
        //construct solution
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i,j));
                }
            }
        }

        return res;
    }
}
