package p201;

class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int mb = bits(m);
        int nb = bits(n);
        if (nb > mb) {
            return 0;
        } else {
            int d = mb;
            while (d >= 0) {
                if ((m >>> d) == (n >>> d)) {
                    d--;
                } else {
                    break;
                }
            }

            if (d < 0) {
                return m;
            }

            return m & (~0 << (d + 1));
        }
    }

    private int bits(int n) {
        int b = -1;

        while (n != 0) {
            b++;
            n = n >>> 1;
        }

        return b;
    }
}
