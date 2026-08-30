//Yoinked from solutions
//Jaden explanation: keep up list of smallest value for that length of substring
//Add or keep updating with at those specific indices to slowly try possibilities.
//Everytime you update a index to a smaller value you are opening up to more pathways for improvement. 
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>(); //Could use an array with an index tracker but arraylist makes it more simple to avoid that complexity.
        dp.add(nums[0]);

        int LIS = 1;
        for (int i = 1; i < nums.length; i++) {
            if (dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
                LIS++;
                continue;
            }

            int idx = Collections.binarySearch(dp, nums[i]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            dp.set(idx, nums[i]);
        }

        return LIS;
    }
}
