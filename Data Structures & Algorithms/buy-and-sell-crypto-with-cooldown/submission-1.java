class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][2];
        
        return dfs(memo, prices, 0, false);
    }

    private int dfs(Integer[][] memo, int[] prices, int curr, boolean holding) {
        if (curr >= prices.length) {
            return 0;
        }
        int state = holding ? 0 : 1;

        if (memo[curr][state] != null) {
            return memo[curr][state];
        }
        
        if (holding) {
            memo[curr][0] = Math.max(prices[curr] + dfs(memo, prices, curr + 2, false), dfs(memo, prices, curr + 1, true));
            return memo[curr][0];
        } else {
            memo[curr][1] = Math.max(-prices[curr] + dfs(memo, prices, curr + 1, true), dfs(memo, prices, curr + 1, false));
            return memo[curr][1];
        }
    } 
}
