class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> options = new ArrayList<>();
        for (int num : nums) options.add(num);
        List<Integer> combo = new ArrayList<>();
        dfs(options, res, combo, nums.length);
        return res;
    }

    private void dfs(List<Integer> options, List<List<Integer>> res, List<Integer> combo, int size) {
        if (combo.size() == size) {
            res.add(new ArrayList<>(combo));
            return;
        }
        
        for (int i = 0; i < options.size(); i++) {
            combo.add(options.get(i));
            options.remove(i);
            dfs(options, res, combo, size);
            options.add(i, combo.get(combo.size() - 1));
            combo.remove(combo.size() - 1);
        }
    }
}