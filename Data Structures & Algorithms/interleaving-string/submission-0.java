class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1, s2, s3, 0, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (i < s1.length() && s3.charAt(k) == s1.charAt(i) && dfs(s1, s2, s3, i + 1, j, k + 1)) {
            return true;
        } 
        if (j < s2.length() && s3.charAt(k) == s2.charAt(j) && dfs(s1, s2, s3, i, j + 1, k + 1)) {
            return true;
        }

        return false;
    }
}
