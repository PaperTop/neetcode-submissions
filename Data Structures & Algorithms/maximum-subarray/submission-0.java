//Strategy: calculate if you need to chop off the left end if it is a net negative
class Solution {
    public int maxSubArray(int[] nums) {
        int l = 0;
        int runTotal = nums[0], maxTotal = nums[0];

        for (int r = 1; r < nums.length; r++) {
            if (runTotal < 0) {
                l = r;
                runTotal = 0;
            }
            runTotal += nums[r];
            maxTotal = Math.max(maxTotal, runTotal);
        }

        return maxTotal;
    }
}
