//bottom up
class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        
        for (int i = 0; i <= coins.length; i++) {
            memo[i][0] = 1;
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[i]) {
                    memo[i][a] = memo[i + 1][a];
                    memo[i][a] += memo[i][a - coins[i]];
                }
            }
        }

        return memo[0][amount]; 
    }
}

