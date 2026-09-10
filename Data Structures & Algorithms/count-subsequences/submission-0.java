/*
Strategy: Can we count how mnay possibilities for each character for every index. Notice for a given letter.
Can we use DFS and save the possibilites for that position? 
*/
class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        dfs(memo, s, t, 0, 0);

        return memo[0][0];
    }

    private int dfs(int[][] memo, String s, String t, int i, int j) {
        //base cases
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        //check memo
        if (memo[i][j] != -1) return memo[i][j];
        
        int res = 0;

        //Always skip
        res += dfs(memo, s, t, i + 1, j);

        //Check if can use the letter        
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(memo, s, t, i + 1, j + 1);
        }

        memo[i][j] = res; 
        return memo[i][j];
    }
}
