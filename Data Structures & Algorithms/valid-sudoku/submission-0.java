class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board[0].length;
        //Check rows and columns
        for (int i = 0; i < length; i++) {
            Set<Character> presentRow = new HashSet<>();
            Set<Character> presentColumn = new HashSet<>();
            for (int j = 0; j < length; j++) {
                if (board[i][j] != '.' && presentRow.contains(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && presentColumn.contains(board[j][i])) {
                    return false;
                }
                presentRow.add(board[i][j]);
                presentColumn.add(board[j][i]);
            }
        }

        //Check boxex
        for (int i = 0; i < length; i+= 3) {
            for (int j = 0; j < length; j+= 3) {
                Set<Character> presentBox = new HashSet<>();
                for (int k = 0; k < 3; k++){
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.' && presentBox.contains(board[i + k][j + l])) {
                            return false;
                        }  
                        presentBox.add(board[i + k][j + l]);
                    }
                }
            }
        }

        return true;
    }
}
