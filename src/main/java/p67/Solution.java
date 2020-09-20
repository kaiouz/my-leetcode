package p67;

class Solution {

    public String addBinary(String a, String b) {
        int resultLen = Math.max(a.length(), b.length()) + 1;
        char[] result = new char[resultLen];

        int ri = resultLen;
        int ai = a.length();
        int bi = b.length();

        while (ai > 0 && bi > 0) {
            ri--;
            ai--;
            bi--;
            char ac = a.charAt(ai);
            char bc = b.charAt(bi);

            if (ac == '0' && bc == '0') {
                plus(result, ri, '0');
            } else if (ac == '1' && bc == '1') {
                plus(result, ri, '1');
                plus(result, ri, '1');
            } else {
                plus(result, ri, '1');
            }

        }

        while (ai > 0) {
            ri--;
            ai--;
            plus(result, ri, a.charAt(ai));
        }

        while (bi > 0) {
            ri--;
            bi--;
            plus(result, ri, b.charAt(bi));
        }

        if (result[0] == 0) {
            return new String(result, 1, resultLen - 1);
        } else {
            return new String(result);
        }
    }

    private void plus(char[] result, int ri, char c) {
        if (result[ri] == 0) {
            result[ri] = c;
        } else if (result[ri] == '0') {
            result[ri] = c;
        } else if (c == '1') {
            result[ri] = '0';
            plus(result, ri - 1, '1');
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1", "111"));
    }
}
