class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        for (int i = 1; i < nums.length; i++) {
            int newLength = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    newLength = Math.max(newLength, memo.get(j) + 1);
                }
            }
            memo.put(i, newLength);
            res = Math.max(res, newLength);
        }
        return res;
    }
}
