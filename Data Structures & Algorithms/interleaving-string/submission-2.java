class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] memo = new boolean[s1.length() + 1][s2.length() + 1];
        memo[s1.length()][s2.length()] = true;
        

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && memo[i + 1][j] && s1.charAt(i) == s3.charAt(i+j)) {
                    memo[i][j] = true;
                }
                if (j < s2.length() && memo[i][j + 1] && s2.charAt(j) == s3.charAt(i+j)) {
                    memo[i][j] = true;
                }
            }
        }

        return memo[0][0];
    }
}
