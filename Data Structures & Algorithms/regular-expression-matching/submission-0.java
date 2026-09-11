class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];

        return dfs(dp, s, p, 0, 0);
    }

    private boolean dfs(Boolean[][] dp, String s, String p, int i, int j) {
        //Base case
        if (j == p.length()) return i == s.length();
        //use memo
        if (dp[i][j] != null) return dp[i][j];

        //check if current characters match
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            //skip *, or use *
            dp[i][j] = dfs(dp, s, p, i, j + 2) || (match && dfs(dp, s, p, i + 1, j));     
        } else {
            dp[i][j] = match && dfs(dp, s, p, i + 1, j + 1); //if curr char matches continue
        }

        return dp[i][j];
    }
}
