class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> exist = new HashSet<>();
        for (int num : nums) {
            exist.add(num);
        }

        int maxLength = 0;
        for (int num : exist) {
            if (!exist.contains(num - 1)) {
                int length = 1; 
                while (exist.contains(num + length)) {
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
