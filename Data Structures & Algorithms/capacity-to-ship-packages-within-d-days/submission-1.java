class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = -1;
        int max = 0;
        for (int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }

        int res = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (check(weights, days, mid)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    public boolean check(int[] weights, int days, int cap) {
        int daysNeed = 1;
        int curr = 0;
        for (int weight : weights) {
            if (curr + weight > cap) {
                curr = 0;
                daysNeed++;
            }
            curr += weight;
        }

        return daysNeed <= days;
    }
}