//Notice that shifting to the right by k is like moving the last k elements to the front
//Reverse whole array, reverse first k, reverse k to end
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1); //move k elements to the front
        reverse(nums, 0, k - 1); //fix the order
        reverse(nums, k, n - 1); //fix the order for the rest
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}