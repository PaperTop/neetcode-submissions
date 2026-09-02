//Start at beginning and always choose the fartest you can go, moving in waves
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int steps = 1, curIdx = 0;
        int farthest = nums[0], curFarthest = nums[0];

        while (farthest < nums.length - 1) {
            for (int i = curIdx; i <= curFarthest; i++) {
                if (i + nums[i] > farthest) {
                    farthest = i + nums[i];
                }
            }
            curIdx = curFarthest + 1;
            curFarthest = farthest;
            steps++;
        }

        return steps;
    }
}
