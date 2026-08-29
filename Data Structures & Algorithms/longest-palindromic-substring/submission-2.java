class Solution {
    public String longestPalindrome(String s) {
        int[] best = {0, 0};

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i, best);       // odd length
            expand(s, i, i + 1, best);   // even length
        }

        return s.substring(best[0], best[1] + 1);
    }

    private void expand(String s, int left, int right, int[] best) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            if (right - left > best[1] - best[0]) {
                best[0] = left;
                best[1] = right;
            }

            left--;
            right++;
        }
    }
}
