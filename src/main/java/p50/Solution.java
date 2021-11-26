package p50;

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? pow(x, N) : 1.0 / pow(x, -N);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double d = pow(x, n / 2);
        if (n % 2 == 1) {
            return x * d * d;
        } else {
            return d * d;
        }
    }
}
