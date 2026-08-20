class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> options = new ArrayList<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
                options.add(num);
            }
            else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        for (Integer option : options) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                for (int j = 0; j < counts.get(option); j++) {
                    subset.add(option);
                    res.add(new ArrayList<>(subset));
                }
            }
        }
        return res;
    }
}
