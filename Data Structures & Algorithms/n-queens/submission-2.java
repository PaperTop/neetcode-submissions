class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] diagr;
    boolean[] diagl;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diagr = new boolean[2 * n];
        diagl = new boolean[2 * n];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(n, board, 0);

        return res;
    }

    private void backtrack(int n, char[][] board, int r) {
        //Add solution to res
        if (r == n) {
            List<String> sol = new ArrayList<>();
            for (char[] row : board) {
                sol.add(new String(row));
            }
            res.add(sol);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || diagr[r - i + n] || diagl[r + i]) {
                continue;
            }

            col[i] = true;
            diagr[r - i + n] = true;
            diagl[r + i] = true;
            board[r][i] = 'Q';
            backtrack(n, board, r + 1);
            col[i] = false;
            diagr[r - i + n] = false;
            diagl[r + i] = false;
            board[r][i] = '.';
        }
    }

}
