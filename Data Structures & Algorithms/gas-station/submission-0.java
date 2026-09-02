//Strat: Chase the tail. Find the segment that results in you have the greatest amount of gas at the peak
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, curTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int change = gas[i] - cost[i];
            totalTank += change;
            curTank += change;

            if (curTank < 0) {
                curTank = 0;
                start = i + 1;
            }
        }

        return totalTank >= 0 ? start : -1;
    }
}
