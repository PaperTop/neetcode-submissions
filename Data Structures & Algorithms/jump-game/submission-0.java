//Strat: start from finish and keep moving the goal backward
class Solution {
    public boolean canJump(int[] nums) {
        int need = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= need) {
                need = i;
            }
        }
        
        return need == 0;
    }
}
