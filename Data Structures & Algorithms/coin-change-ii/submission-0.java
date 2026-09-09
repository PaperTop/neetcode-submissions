//Brute force recurssively all possibilities
class Solution {
    public int change(int amount, int[] coins) {
        return dfs(amount, coins, 0);
    }

    private int dfs(int amount, int[] coins, int curr) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || curr >= coins.length) {
            return 0;
        }

        int repeat = dfs(amount - coins[curr], coins, curr);
        int skip = dfs(amount, coins, curr + 1);

        return repeat + skip;
    }
}
