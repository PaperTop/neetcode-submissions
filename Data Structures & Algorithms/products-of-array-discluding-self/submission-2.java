class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                prod *= nums[i];
            }
            else {
                zeroCnt++;
            }
        }

        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (zeroCnt > 1) {
                res[i] = 0;
            }
            else if (zeroCnt > 0) {
                if (nums[i] == 0) {
                    res[i] = prod;
                }
                else {
                    res[i] = 0;
                }
            }
            else {
                res[i] = prod / nums[i];
            }
        }

        return res;
    }
}  
