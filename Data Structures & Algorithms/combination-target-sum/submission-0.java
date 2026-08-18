class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();        
        int sum = 0;
        int i = 0;
        dfs(nums, target, res, combo, sum, i);
        return res;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> combo, int sum, int i) {
        if (sum > target || i >= nums.length) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(combo));
            return;
        }   

        //Repeat same position
        combo.add(nums[i]);
        sum += nums[i];
        dfs(nums, target, res, combo, sum, i);
        combo.removeLast();
        sum -= nums[i];

        //Skip current
        dfs(nums, target, res, combo, sum, i + 1);
    }
}
