//Optimized version of the previous, just uses one row O(m*n) time but O(min(m,n)) space
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text2;
            text2 = text1;
            text1 = temp;
        }
        int[] dp = new int[text2.length() + 1];
        int[] cur = new int[text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    cur[j] = 1 + dp[j + 1];
                } else {
                    cur[j] = Math.max(cur[j + 1], dp[j]);
                }
            }
            for (int k = 0; k < dp.length - 1; k++) {
                dp[k] = cur[k];
            }
            Arrays.fill(cur, 0);
        }

        return dp[0];
    }
}
