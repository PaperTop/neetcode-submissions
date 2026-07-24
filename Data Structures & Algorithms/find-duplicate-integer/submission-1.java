class Solution {
    public int findDuplicate(int[] nums) {
        //Solution using modification
        for (int num: nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                return Math.abs(num);
            }
            else {
                nums[idx] *= -1;
            }
        }
        return -1;
    }
}
