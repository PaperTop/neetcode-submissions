//improvements
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = res - 1; i >= 0; i--) {
            res += i - nums[i];
        } 
        return res;
    }
}
