class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int costA = 0;
        int costB = 0;
        
        for (int i = 2; i < cost.length + 1; i++) {
            int costC = Math.min(costA + cost[i - 2], costB + cost[i -1]);
            costA = costB;
            costB = costC; 
        }

        return costB;
    }
}
