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

        if (zeroCnt > 1) {
            return new int[nums.length];
        }
        int[] res = new int[nums.length];
        
        
        for (int i = 0; i < nums.length; i++) {
            if (zeroCnt > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
            }
            else {
                res[i] = prod / nums[i];
            }
        }

        return res;
    }
}  
