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
        if (target < 0) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            
            combo.add(candidates[j]);
            dfs(candidates, target - candidates[j], res, combo, j + 1);
            combo.remove(combo.size() - 1);
        }
    }
}
