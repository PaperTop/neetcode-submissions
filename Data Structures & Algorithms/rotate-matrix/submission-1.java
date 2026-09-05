//rotate vertically and then transpose
class Solution {
    public void rotate(int[][] matrix) {
        //rotate vertically
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i]; //store row
            matrix[i] = matrix[n - i - 1]; //replace cur row with the bottom one
            matrix[n - i - 1] = temp; //replace bottom one with temp/the top
        }

        //transpose want to the first row to be become the last column just swaps the rows with the columns
        for (int i = 0; i < matrix.length; i++) {          
            for (int j = i; j < matrix[i].length; j++) {   
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
