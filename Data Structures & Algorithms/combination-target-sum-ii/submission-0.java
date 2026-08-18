class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        int i = 0;
        Arrays.sort(candidates);
        dfs(candidates, target, res, combo, i);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combo, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if (target < 0 || i >= candidates.length) {
            return;
        }

        combo.add(candidates[i]);
        dfs(candidates, target - candidates[i], res, combo, i + 1);
        combo.removeLast();

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, target, res, combo, i + 1);
        
    }
}
