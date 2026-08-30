//Optimization: By sorting the array first we could technically end the inner loop early and save run time. However because the sort runs in nlogn time it is overshadowed by the main run time of n * t. if t becomes very large it will dominate but nlogn sort could possiblty reduce runtime in the real world.''
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] bests = new int[amount + 1];
        bests[0] = 0;

        for (int i = 1; i < bests.length; i++) {
            int smallest = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    break;
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
