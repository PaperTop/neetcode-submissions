class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLength = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            if (seen.containsKey(s.charAt(r))) {
                l = Math.max(seen.get(s.charAt(r)) + 1, l);
            }
            seen.put(s.charAt(r), r);
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
