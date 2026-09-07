/* 
Jaden explanation: solution is actually genius
Idea: each cell possibilites = below and right
bottom row all has 1.

*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); //bottom row all have 1 possibility

        for (int i = m - 2; i >= 0; i--) { //start from 2nd to the last row
            for (int j = n - 2; j >= 0; j--) { //start from 2nd to the end of the column
                dp[j] += dp[j + 1]; //dp[j] is the value from below then you add the value to the right
            }
        }

        return dp[0];
    }
}
