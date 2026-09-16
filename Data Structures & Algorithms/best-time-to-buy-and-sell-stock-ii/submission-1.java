class Solution {
    public int maxProfit(int[] prices) {
        boolean stock = false;
        int res = 0;
        int cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (!stock) {
                while (i < prices.length && prices[i] <= cur) {
                    cur = prices[i];
                    i++;
                }
                i--;
                res -= cur;
                stock = true;
            } else {
                while (i < prices.length && prices[i] >= cur) {
                    cur = prices[i];
                    i++;
                }
                i--;
                res += cur;
                stock = false;
            }
        }
        if (stock) {
            res += cur;
        }
        return res;
    }
}