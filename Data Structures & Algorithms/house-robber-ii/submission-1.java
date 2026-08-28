class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        int res = b;
        a = 0;
        b = 0;
        for (int i = 1; i < nums.length; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }

        return Math.max(res, b);
    }
}
