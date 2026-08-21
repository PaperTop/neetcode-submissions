class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int idx = 0;
                    if (dfs(board, word, idx, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#' || board[x][y] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1 && board[x][y] == word.charAt(idx)) {
            return true;
        }
        char save = board[x][y];
        board[x][y] = '#';
        idx++;
        boolean res = dfs(board, word, idx, x, y - 1) || dfs(board, word, idx, x - 1, y) || dfs(board, word, idx, x, y + 1) || dfs(board, word, idx, x + 1, y);
        board[x][y] = save;
        
        return res;
    }
}
