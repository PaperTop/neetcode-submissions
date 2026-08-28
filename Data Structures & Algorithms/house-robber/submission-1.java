//Really only need at the last n - 2 anc n - 3 value. Which has a higher value
class Solution {
    public int rob(int[] nums) {
        int max = nums[0];
        int curr = 0;

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        else if (nums.length >= 3) {
            nums[2] += nums[0];
            max = Math.max(max, nums[1]);
            max = Math.max(max, nums[2]);
        }
        for (int i = 3; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
            max = Math.max(max, nums[i]);
        }

        return max;    
    }
}
