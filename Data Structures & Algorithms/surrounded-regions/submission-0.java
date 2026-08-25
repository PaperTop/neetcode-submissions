//Strategy: start at perimeter and grow inward
class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        //Add the Os on the border
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'S';
                q.offer(new int[]{0,i});
            }
            if (board[board.length - 1][i] == 'O') {
                board[board.length - 1][i] = 'S';
                q.offer(new int[]{board.length-1, i});
            } 
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'S';
                q.offer(new int[]{i,0});
            }
            if (board[i][board[0].length - 1] == 'O') {
                board[i][board[0].length - 1] = 'S';
                q.offer(new int[]{i,board[0].length - 1});
            }
        }

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] pt = q.poll();
            int r = pt[0], c = pt[1];
            for (int[] d : dir) {
                int newR = r + d[0], newC = c + d[1];
                if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && board[newR][newC] == 'O') {
                    board[newR][newC] = 'S';
                    q.offer(new int[]{newR,newC});
                }
            }
        }

        //clean up
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
