/* 
Strategy (original thoughts): how many times can we use each coin for each amount of money
*/
class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < amount; i++) {
                if (i + coin <= amount) {
                    memo[i + coin] += memo[i];
                }
            }
        }

        return memo[amount]; 
    }
}
