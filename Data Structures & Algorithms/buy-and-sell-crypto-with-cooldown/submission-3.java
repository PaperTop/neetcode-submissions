class Solution {
    public int maxProfit(int[] prices) {
        int[] twoEarly = {0, 0};
        int[] oneEarly = {0, 0};

        for (int i = prices.length - 1; i >= 0; i--) {
            int[] cur = {Math.max(prices[i] + twoEarly[1], oneEarly[0]),
                         Math.max(-prices[i] + oneEarly[0], oneEarly[1])} ;
            twoEarly = oneEarly;
            oneEarly = cur;
        }

        return oneEarly[1];
    }
}
