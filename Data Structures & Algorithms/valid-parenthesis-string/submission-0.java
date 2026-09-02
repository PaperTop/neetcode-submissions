class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (c == '*') {
                maxOpen++;
                minOpen--;
            } else if (c == ')') {
                maxOpen--;
                minOpen--;
            }

            minOpen = Math.max(minOpen, 0);
            if (maxOpen < 0) {
                return false;
            }
        }
        
        return minOpen == 0;
    }
}
