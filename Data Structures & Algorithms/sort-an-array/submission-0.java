//Merge sort
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int idx = 0;
        int i = l;
        int j = m + 1;
        
        while (i <= m && j <= r) {
            //choose the smaller one
            if (nums[i] <= nums[j]) {
                tmp[idx] = nums[i];
                i++;
            } else {
                tmp[idx] = nums[j];
                j++;
            }
            idx++;
        }
        //Add remaining
        while (i <= m) {
            tmp[idx] = nums[i];
            i++;
            idx++;
        }
        while (j <= r) {
            tmp[idx] = nums[j];
            j++;
            idx++;
        }

        //Update nums with the new values
        for (i = l; i <= r; i++) {
            nums[i] = tmp[i - l];
        }

    }
}