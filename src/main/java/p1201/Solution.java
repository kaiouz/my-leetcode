package p1201;

class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = Math.min(a, Math.min(b, c)) * n;
        int pivot = left;

        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);

        while (left <= right) {
            pivot = left + (right - left) / 2;
            long num = pivot / a + pivot / b + pivot / c - pivot / ab - pivot / ac - pivot / bc + pivot / abc;
            if (num > n) {
                right = pivot - 1;
            } else if (num < n) {
                left = pivot + 1;
            } else {
                if (pivot % a == 0 || pivot % b == 0 || pivot % c == 0) {
                    return pivot;
                } else {
                    right = pivot - 1;
                }
            }
        }

        return left;
    }

    private long lcm(long x, long y) {
        long gcd = gcd(x, y);
        return x * y / gcd;
    }

    private long gcd(long x, long y) {
        long temp = x % y;
        if (temp > 0) {
            return gcd(y, temp);
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1000000000,
                2,
                217983653,
                336916467
        ));
    }
}
