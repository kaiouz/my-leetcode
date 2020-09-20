package p43;

class Solution {

    public String multiply(String num1, String num2) {
        String r = "0";

        for (int i = 0; i < num1.length(); i++) {
           r = plus(r, muti(num2, num1.charAt(num1.length() - 1 - i) - '0', i));
        }

        return r;
    }

    private String plus(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0 || carry > 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1--) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2--) - '0' : 0;
            carry += n1 + n2;
            sb.insert(0, carry % 10);
            carry /= 10;
        }
        return sb.toString();
    }

    private String muti(String num, int n, int w) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = num.length() - 1;

        while (i >= 0 || carry > 0) {
            int n1 = i >= 0 ? num.charAt(i--) - '0' : 0;
            carry = n1 * n + carry;
            sb.insert(0, carry % 10);
            carry /= 10;
        }

        if (sb.charAt(0) != '0') {
            for (i = 0; i < w; i++) {
                sb.append('0');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("9133", "0"));
    }
}
