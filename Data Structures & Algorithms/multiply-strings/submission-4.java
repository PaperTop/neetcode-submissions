//Simulate multiplication by hand
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder bottom = new StringBuilder(mult(num1.substring(i, i+1), num2));
            for (int j = 0; j < num1.length() - i - 1; j++) {
                bottom.append('0');
            }
            res = add(res, bottom.toString());
        }
        return res;
    }

    private String mult(String a, String b) {
        StringBuilder res = new StringBuilder();
        int aInt = a.charAt(0) - '0';
        int carry = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            int bInt = b.charAt(i) - '0';
            int total = carry + bInt * aInt;

            res.append(total % 10);
            carry = total / 10;
        }
        if (carry > 0) res.append(carry);

        return res.reverse().toString();
    }

    private String add(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int aInt = i >= 0 ? a.charAt(i) - '0' : 0;
            int bInt = j >= 0 ? b.charAt(j) - '0' : 0;

            int total = aInt + bInt + carry;

            res.append(total % 10);
            carry = total / 10;

            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
