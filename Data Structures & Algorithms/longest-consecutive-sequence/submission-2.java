class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            exist.add(nums[i]);
        }

        int maxLength = 1;
        for (int num : exist) {
            if (!(exist.contains(num - 1))) {
                int length = 1; 
                int curr = num;
                while (exist.contains(curr + 1)) {
                    length++;
                    curr++;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}
