//space improved from previous
class Solution {
    public int rob(int[] nums) {
        int houseA = 0;
        int houseB = 0;

        for (int i = 0; i < nums.length; i++) {
            int houseC = Math.max(nums[i] + houseA, houseB);
            houseA = houseB;
            houseB = houseC;
        }

        return houseB;    
    }
}
