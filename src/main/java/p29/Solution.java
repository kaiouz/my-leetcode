package p29;

class Solution {

    public int divide(int dividend, int divisor) {
        int op = 1;
        long dividendL = dividend;
        if (dividend < 0) {
            op *= -1;
            dividendL = -dividendL;
        }
        long divisorL = divisor;
        if (divisor < 0) {
            op *= -1;
            divisorL = -divisorL;
        }

        if (dividendL < divisorL) {
            return 0;
        }

        long n = 1;
        long s = divisorL;

        while (s + s <= dividendL) {
            n += n;
            s += s;
        }

        long ans;
        if (s == dividendL) {
            ans = n;
        } else {
            ans = n + divide((int)(dividendL - s), (int)divisorL);
        }

        ans *= op;

        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648,-1));
    }
}
