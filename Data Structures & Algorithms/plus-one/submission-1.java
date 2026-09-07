//improvements clean
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry = 1;
        while (carry > 0 && i >= 0) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                carry = 0;
            }
            i--;
        }

        if (carry == 1 && i == -1) {
            int[] big = new int[digits.length + 1];
            big[0] = 1;
            return big;
        }

        return digits;
    }
}
