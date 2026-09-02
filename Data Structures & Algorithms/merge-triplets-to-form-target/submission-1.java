/* 
Improvements: cleaned up unessary loop, with a single if statement. dont actually need int array when you can use booleans.
*/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] cur = new boolean[3];
        for (int[] trip : triplets) {
            if (trip[0] > target[0] || trip[1] > target[1] || trip[2] > target[2]) {
                continue;
            }
            
            cur[0] = trip[0] == target[0] ? true : cur[0];
            cur[1] = trip[1] == target[1] ? true : cur[1];
            cur[2] = trip[2] == target[2] ? true : cur[2];

            if (cur[0] && cur[1] && cur[2]) {
                return true;
            }
        }

        return false;
    }
}
