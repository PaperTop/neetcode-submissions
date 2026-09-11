//DFS top down approach
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(memo, word1, word2, 0, 0);
    }

    private int dfs(int[][] memo, String word1, String word2, int i, int j) {
        //sucess
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        //memo check
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        //if character already matches else try the other methods
        if (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dfs(memo, word1, word2, i + 1, j + 1);
        } else {
            //insert, delete, replace
            int insert = 1 + dfs(memo, word1, word2, i, j + 1);
            int delete = 1 + dfs(memo, word1, word2, i + 1, j);
            int replace = 1 + dfs(memo, word1, word2, i + 1, j + 1);

            //update memo
            memo[i][j] = Math.min(delete, Math.min(insert, replace));
        }

        return memo[i][j];
    }
}
