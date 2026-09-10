//Space optimization notice how we only use the values below and to the right. Instead of holding all the rows and columns we can just use an array to store the current below. As we calculate we can replace it with the new row.
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() < s2.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }

        boolean[] memo = new boolean[s2.length() + 1];
        memo[s2.length()] = true;
        
        for (int i = s1.length(); i >= 0; i--) {
            boolean nextMemo = i == s1.length();
            for (int j = s2.length(); j >= 0; j--) {
                boolean res = j < s2.length() ? false : nextMemo;
                //check below
                if (i < s1.length() && memo[j] && s1.charAt(i) == s3.charAt(i+j)) {
                    res = true;
                }
                //check to the right
                if (j < s2.length() && nextMemo && s2.charAt(j) == s3.charAt(i+j)) {
                    res = true;
                }

                memo[j] = res;
                nextMemo = memo[j];
            }
        }

        return memo[0];
    }
}
