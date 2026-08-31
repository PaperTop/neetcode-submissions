class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        int n = nums.length;
        boolean[][] memo = new boolean[target + 1][n + 1];
        //initialize zero
        for (int i = 0; i <= n; i++) {
            memo[0][i] = true;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                int curVal = nums[j - 1];

                memo[i][j] = memo[i][j - 1];

                if (i >= curVal) {
                    memo[i][j] = memo[i][j] || memo[i - curVal][j - 1];
                }
            }
        }
        return memo[target][n];
    }
}
