package p8;

class Solution {

    public int myAtoi(String s) {
        long ans = 0;

        int i = 0;
        int op = 1;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length()) {
            int c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (c == '-') {
                    op = -1;
                }
                i++;
            }
        }

        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                ans = ans * 10 + (c - '0');
                if (op == 1 && ans > max) {
                    return Integer.MAX_VALUE;
                }
                if (op == -1 && -ans < min) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            i++;
        }

        return (int) (ans * op);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-42"));
    }
}
