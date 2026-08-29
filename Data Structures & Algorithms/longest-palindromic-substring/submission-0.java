//Stratey expanding centers
class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        //Moving center
        for (int i = 0; i < s.length(); i++) {
            int expansion = Math.min(s.length() - i - 1, i);
            for (int j = 1; j <= expansion; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                //update if longer
                if (s.substring(i - j, i + j + 1).length() > res.length()) {
                    res = s.substring(i - j, i + j + 1);
                }
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            int expansion = Math.min(s.length() - i - 2, i);
            for (int j = 0; j <= expansion; j++) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                    break;
                }
                if (s.substring(i - j, i + j + 2).length() > res.length()) {
                    res = s.substring(i - j, i + j + 2);
                }
            }
        }


        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length();
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
