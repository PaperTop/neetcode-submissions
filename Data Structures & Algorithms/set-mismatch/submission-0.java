class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] seen = new int[nums.length];
        
        int twice = 0;
        for (int i = 0; i < nums.length; i++) {
            if (seen[nums[i] - 1] == 0) {
                seen[nums[i] - 1] = 1;
            } else {
                twice = nums[i];
            }
        }

        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            if (seen[i] == 0) {
                missing = i + 1;
            }
        }

        return new int[]{twice, missing};
    }
}