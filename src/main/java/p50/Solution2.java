package p50;

public class Solution2 {

    public double myPow(double x, int n) {
        double ans = 1.0;

        double cur = x;
        int t = n >= 0 ? n : -n;

        while (t != 0) {
            if ((t & 1) == 1) {
                ans *= cur;
            }
            cur = cur * cur;
            t = t >>> 1;
        }

        if (n < 0) {
            ans = 1.0 / ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().myPow(2.0, -2));
    }
}
