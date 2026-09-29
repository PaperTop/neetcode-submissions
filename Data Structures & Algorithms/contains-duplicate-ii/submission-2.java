//We can try to use a sliding window where we use a hashset to see if that number already exists in that window. We would also need to consider the case where k >= nums.length
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        //Case where k is greater than or equal to nums.length
        //Simple duplicate check
        if (k + 1 >= nums.length) {
            for (int n : nums) {
                if (seen.contains(n)) {
                    return true;
                } else {
                    seen.add(n);
                }
            }
            return false;
        }

        //Set up initial window with duplicate check
        for (int i = 0; i <= k; i++) {
            if (seen.contains(nums[i])) {
                return true;
            } else {
                seen.add(nums[i]);
            }
        }

        int l = 0;
        for (int r = k + 1; r < nums.length; r++) {
            //Remove end and add beginning
            seen.remove(nums[l]);
            if (seen.contains(nums[r])) {
                return true;
            } else {
                seen.add(nums[r]);
            }
            l++;
        }

        return false;
    }
}