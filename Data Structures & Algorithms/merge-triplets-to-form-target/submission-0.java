/* 
Strategy: Update if can get a target value without ruining another thing
Can get target value means one of the val in trips are equal to target
Without ruin = no other val higher than any corresponding target val
*/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = {0, 0, 0};
        for (int[] trip : triplets) {
            int invalid = 0;
            for (int i = 0; i < 3; i++) {
                if (trip[i] > target[i]) {
                    invalid++;
                    break;
                }
            }
            if (invalid == 0) {
                cur[0] = Math.max(cur[0], trip[0]);
                cur[1] = Math.max(cur[1], trip[1]);
                cur[2] = Math.max(cur[2], trip[2]);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cur[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
