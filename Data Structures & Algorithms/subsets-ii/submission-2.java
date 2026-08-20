class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort nums
        Arrays.sort(nums);
        //hold our answers
        List<List<Integer>> res = new ArrayList<>();
        //add the empty subset
        res.add(new ArrayList<>());
        
        int prevIdx = 0;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            //if the current num is equal to the previous set idx to prevIdx else it is 0
            idx = (i >= 1 && nums[i] == nums[i - 1]) ? prevIdx : 0;
            prevIdx = res.size();
            for (int j = idx; j < prevIdx; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
