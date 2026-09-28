//clean up
class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            while (l <= r && nums[l] == val) {
                nums[l] = nums[r];
                r--;
            }
            l++;
        }

        return r + 1;
    }
}