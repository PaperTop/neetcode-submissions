//bottom up dp, linear time and space
class Solution {
    public int maxProfit(int[] prices) {
        // where dp[i][0] represents holding and dp[i][1] represents not holding
        int[][] dp = new int[prices.length + 2][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            //am holding
            dp[i][0] = Math.max( prices[i] + dp[i + 2][1], // sell
                                 dp[i + 1][0]              // keep holding
                                );
            //not holding
            dp[i][1] = Math.max( -prices[i] + dp[i + 1][0], // buy
                                 dp[i + 1][1]                // skip
                                );
        }

        return dp[0][1];
    }
}
