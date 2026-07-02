class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        
        int res = 0;
        for (int num : nums) {
            if (!seen.contains(num - 1)) {
                int length = 1;
                int currNum = num;
                while (seen.contains(currNum + 1)) {
                    length++;
                    currNum++;
                }
                res = Math.max(res, length);
            }
        }

        return res;
    }
}
