package p415;

class Solution {

    public String addStrings(String num1, String num2) {
        char[] result = new char[5100];
        int i = 0;
        int carry = 0;

        while (i < num1.length() || i < num2.length() || carry > 0) {
            i++;
            int n1 = i <= num1.length() ? num1.charAt(num1.length() - i) - '0' : 0;
            int n2 = i <= num2.length() ? num2.charAt(num2.length() - i) - '0' : 0;
            carry = carry + n1 + n2;
            result[result.length - i] = (char) ((carry % 10) + '0');
            carry = carry / 10;
        }

        return new String(result, result.length - i, i);
    }

}
