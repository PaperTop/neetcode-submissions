class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] bests = new int[amount + 1];
        bests[0] = 0;

        for (int i = 1; i < bests.length; i++) {
            int smallest = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                if (bests[i - coin] != -1) {
                    
                    smallest = Math.min(smallest, bests[i - coin] + 1);
                }
            }

            if (smallest == Integer.MAX_VALUE) {
                bests[i] = -1;
            } else {
                bests[i] = smallest;
            }
        }

        return bests[bests.length - 1];
    }
}
