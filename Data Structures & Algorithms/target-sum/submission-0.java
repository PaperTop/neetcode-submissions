class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);

        //for each num
        for (int num : nums) {
            //iterate over values so far
            Map<Integer, Integer> next = new HashMap<>();
            for (int sum : memo.keySet()) {
                next.put(sum + num, next.getOrDefault(sum + num, 0) + memo.get(sum));
                next.put(sum - num, next.getOrDefault(sum - num, 0) + memo.get(sum));
            }
            memo = next;
        }

        return memo.getOrDefault(target, 0);
    }
}
