class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> exist = new HashSet<>();
        for (int num : nums) {
            exist.add(num);
        }

        int maxLength = 0;
        for (int num : exist) {
            if (!exist.contains(num - 1)) {
                int length = 1; 
                int curr = num;
                while (exist.contains(curr + 1)) {
                    length++;
                    curr++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
