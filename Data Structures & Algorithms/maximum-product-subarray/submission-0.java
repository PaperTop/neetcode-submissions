class Solution {
    public int maxProduct(int[] nums) {
        int trueMax = nums[0];
        int runMax = nums[0];
        int runMin= nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int itself = nums[i];
            int mulMax = runMax * nums[i];
            int mulMin = runMin * nums[i];
            
            
            runMax = Math.max(mulMin, mulMax);
            runMax = Math.max(runMax, itself);

            runMin = Math.min(mulMax, mulMin);
            runMin = Math.min(runMin, itself);

            trueMax = Math.max(trueMax, runMax);

        }

        return trueMax;
    }
}
