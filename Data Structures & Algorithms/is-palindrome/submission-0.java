class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder flipped = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)){
                flipped.append(Character.toLowerCase(c));
            }
        }

        return flipped.toString().equals(flipped.reverse().toString());
    }
}
