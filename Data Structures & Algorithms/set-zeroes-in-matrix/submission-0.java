class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];

        for (int[] row : temp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {

                    // zero row
                    Arrays.fill(temp[i], 0);

                    // zero column
                    for (int c = 0; c < matrix.length; c++) {
                        temp[c][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (temp[i][j] == -1) {
                    temp[i][j] = matrix[i][j];
                }

                matrix[i][j] = temp[i][j];
            }
        }
    }
}