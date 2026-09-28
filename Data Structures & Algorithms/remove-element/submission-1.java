class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            //while val then swap with the end
            while (l <= r && nums[l] == val) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
                r--;
            }

            l++;
        }

        return r + 1;
    }
}