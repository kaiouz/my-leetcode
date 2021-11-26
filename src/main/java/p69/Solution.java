package p69;

class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        int mid = 0;
        int ans = -1;

        while (l <= r) {
            mid = (l + r) / 2;
            long v = (long) mid * mid;
            if (v > x) {
                r = mid - 1;
            } else if (v < x) {
                l = mid + 1;
                ans = mid;
            } else {
                return mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
}
