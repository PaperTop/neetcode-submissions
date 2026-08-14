class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int pivot = right;

        while (left <= right) {

            pivot = partition(nums, left, right);

            if (pivot == nums.length - k) {
                return nums[pivot];
            } else if (pivot > nums.length - k) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return nums[pivot];
    }

    private int partition(int[] nums, int l, int r) {
        int i = l;
        for (int search = l; search < r; search++) {
            if (nums[search] < nums[r]){
                int tmp = nums[search];
                nums[search] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }

        int tmp = nums[r];
        nums[r] = nums[i];
        nums[i] = tmp;
        return i;
    }
}
