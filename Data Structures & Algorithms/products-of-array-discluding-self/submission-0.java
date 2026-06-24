class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    res[i] *= nums[j];
                }
            }
        }

        return res;
    }
}  
