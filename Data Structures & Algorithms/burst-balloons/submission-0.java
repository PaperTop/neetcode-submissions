class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // figure out traversal here
        for (int len = 2; len < arr.length; len++) {
            for (int l = 0; l + len < arr.length; l++) {
                int r = l + len;
                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][i] + arr[l] * arr[i] * arr[r] + dp[i][r]);
                }
            }
        }

        return dp[0][n + 1];
    }
}