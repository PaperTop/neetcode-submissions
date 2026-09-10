//Space optimized bottom up approach
//Notice how we only use the one row below or row below and one ahead. This means we can just use one row to memo this.
class Solution {
    public int numDistinct(String s, String t) {
        int[] memo = new int[t.length() + 1];
        //Base case where j length == t.length()
        memo[t.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    memo[j] += memo[j + 1];
                }
            }
        }
        
        return memo[0];
    }
}
