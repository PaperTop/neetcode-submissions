//Clean up previous
class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int curEnd = 0;
        int farthest = 0;

        // Loop up to nums.length - 2 because once curEnd reaches the last index,
        // no additional jump is required.
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // Hit the boundary of the current jump/wave
            if (i == curEnd) {
                steps++;
                curEnd = farthest;
            }
        }

        return steps;
    }
}
