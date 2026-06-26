class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int total = -(nums[i]);
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] < total) {
                    l++;
                }
                else if (nums[l] + nums[r] > total) {
                    r--;
                }
                else {
                    res.add(List.of(nums[l], nums[r], nums[i]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }            
        }
        return res; 
    }
}
