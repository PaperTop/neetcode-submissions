//can think about it as adding a digit to the end of a list
//need to count the previous number of combinations with the n digits
//see the change with one additinal digit then keep building
class Solution {
    public int numDecodings(String s) {
        int twoAway = 1; //# of valid decodings for the prefix ending at the prev prev index.
        int oneAway = 0; //# of valid decodings for the prefix ending at the previous index.

        if (s.charAt(0) != '0') {
            oneAway = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            int cur = 0;
            if (s.charAt(i) != '0') {
                cur += oneAway;
            }

            int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if ( twoDigits >= 10 && twoDigits <= 26) {
                cur += twoAway;
            }

            twoAway = oneAway;
            oneAway = cur;
        }

        return oneAway;
    }
}
