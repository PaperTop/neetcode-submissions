//Bottom up approach starting from the end
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];

        //Set up base cases when each has reached the end
        for (int j = 0; j <= word2.length(); j++) {
            memo[word1.length()][j] = word2.length() - j;
        }
        for (int i = 0; i <= word1.length(); i++) {
            memo[i][word2.length()] = word1.length() - i;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    memo[i][j] = memo[i + 1][j + 1]; //char matches = skip to next letter
                } else {
                    //1 + min of delete, replace, add
                    memo[i][j] = 1 + Math.min(memo[i + 1][j], Math.min(memo[i][j + 1], memo[i + 1][j + 1]));
                }
            }
        }

        return memo[0][0];
    }
}
