//Bottom up with space optimization notice how we only use one row
class Solution {
    public int minDistance(String word1, String word2) {
        //swap for smaller word
        if (word1.length() < word2.length()) {
            String tmp = word2;
            word2 = word1;
            word1 = tmp;
        }
        int[] memo = new int[word2.length() + 1];

        // Base case:
        // word1 is exhausted, so insert remaining word2 chars
        for (int j = 0; j <= word2.length(); j++) {
            memo[j] = word2.length() - j;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            // old memo[n] = dp[i + 1][n]
            int diagonal = memo[word2.length()];
            // word2 exhausted -> delete remaining word1 chars
            memo[word2.length()] = word1.length() - i;

            for (int j = word2.length() - 1; j >= 0; j--) {
                // Save dp[i + 1][j] before overwriting it
                int below = memo[j];

                if (word1.charAt(i) == word2.charAt(j)) {
                    memo[j] = diagonal;
                } else {
                    //delete, insert, replace
                    memo[j] = 1 + Math.min(below, Math.min(memo[j + 1], diagonal));
                }

                // For the next j, old dp[i + 1][j] becomes diagonal
                diagonal = below;
            }
        }

        return memo[0];
    }
}

