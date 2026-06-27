class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int value;

        while (l <= r) {
            value = nums[l + (r - l) / 2];
            if (target > value) {
                l = l + (r - l) / 2 + 1;
            }
            else if (target < value) {
                r = l + (r - l) / 2 - 1;
            }
            else {
                return l + (r - l) / 2;
            }
        }


        return -1;
    }
}
