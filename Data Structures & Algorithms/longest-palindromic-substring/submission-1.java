//Improvements
class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 1;
        //Moving center
        for (int i = 0; i < s.length(); i++) {
            int expansion = Math.min(s.length() - i - 1, i);
            for (int j = 1; j <= expansion; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                //update if longer
                if (2 * j + 1 > right - left) {
                    left = i - j;
                    right = i + j + 1;
                }
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            int expansion = Math.min(s.length() - i - 2, i);
            for (int j = 0; j <= expansion; j++) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                    break;
                }
                if (2 * j + 2 > right - left) {
                    left = i - j;
                    right = i + j + 2;
                }
            }
        }

        return s.substring(left, right);
    }
}

