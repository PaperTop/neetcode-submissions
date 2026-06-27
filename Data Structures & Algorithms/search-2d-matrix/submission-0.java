class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int mRow = m / matrix[0].length; 
            int mCol = m % matrix[0].length;
            
            
            if (matrix[mRow][mCol] > target) {
                r = m - 1;
            }
            else if (matrix[mRow][mCol] < target) {
                l = m + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
