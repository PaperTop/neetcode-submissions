class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> diagr = new HashSet<>();
    Set<Integer> diagl = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
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
            if (col.contains(i) || diagr.contains(r - i) || diagl.contains(r + i)) {
                continue;
            }

            col.add(i);
            diagr.add(r - i);
            diagl.add(r + i);
            board[r][i] = 'Q';
            backtrack(n, board, r + 1);
            col.remove(i);
            diagr.remove(r - i);
            diagl.remove(r + i);
            board[r][i] = '.';
        }
    }

}
