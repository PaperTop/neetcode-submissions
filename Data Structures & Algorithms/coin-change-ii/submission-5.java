//top down with sorting
class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(memo, amount, coins, 0);
    }

    private int dfs(int[][] memo, int amount, int[] coins, int curr) {
        if (amount == 0) return 1;
        if (curr >= coins.length) return 0;
        if (memo[curr][amount] != -1) return memo[curr][amount];

        int res = 0;
        if (amount >= coins[curr]) {
            res += dfs(memo, amount - coins[curr], coins, curr);
            res += dfs(memo, amount, coins, curr + 1);
        }
        
        memo[curr][amount] = res;
        return res;
    }
}

