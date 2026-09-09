class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(memo, s1, s2, s3, 0, 0);
    }

    private boolean dfs(Boolean[][] memo, String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean t1 = i < s1.length() && s3.charAt(i + j) == s1.charAt(i) && dfs(memo, s1, s2, s3, i + 1, j);
        boolean t2 = j < s2.length() && s3.charAt(i + j) == s2.charAt(j) && dfs(memo, s1, s2, s3, i, j + 1);
    
        memo[i][j] = t1 || t2;
        
        return memo[i][j];
    }
}

