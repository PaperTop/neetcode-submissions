class Solution {
    public int missingNumber(int[] nums) {
        int xorr = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xorr ^= i ^ nums[i];
        }
        return xorr;
    }
}
