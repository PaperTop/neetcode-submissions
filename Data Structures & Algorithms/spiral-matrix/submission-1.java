//Strategy: Notice how the length continously decreases for each loop want to write a loop that uses the current iteration to decrease its power
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[] steps = {matrix[0].length, matrix.length -1};

        int r = 0; // row 
        int c= -1; // column
        int d = 0; //track which dir we are on
        while (steps[d % 2] > 0) {
            for (int i = 0; i < steps[d % 2]; i++) {
                r += dir[d][0];
                c += dir[d][1];
                res.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d + 1) % 4;
        }

        return res;
    }
}
