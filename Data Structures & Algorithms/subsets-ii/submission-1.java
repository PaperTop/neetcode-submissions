class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        int i = 0;
        dfs(nums, res, subset, i);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, Set<List<Integer>> res, List<Integer> subset, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, res, subset, i + 1);
        subset.remove(subset.size() - 1);
        dfs(nums, res, subset, i + 1);
    }
}
